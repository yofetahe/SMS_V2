package com.fidel.sms.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.ExamResultDao;
import com.fidel.sms.model.DAAttendance;
import com.fidel.sms.model.ExamResult;
import com.fidel.sms.model.ExamResultComment;
import com.fidel.sms.model.ExamSchedule;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.SubjectClassRelation;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.model.TeacherHomeRoomAssignment;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.utils.ReturnCurrentEthiopianYear;

@Repository
public class ExamResultDaoImpl implements ExamResultDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ExamResultDaoImpl(){}
	
	public ExamResultDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ExamResult> getUnfilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(int cl_id, int cd_id,
			int exsub_id, int at_id, int academic_year) {

		final String hql = "SELECT b.si_id, b.fname, b.mname, b.gname, f.total_mark, f.pass_mark "
						+ "FROM stud_information b, stud_registration c, clist_cdetail_rel d, subject_class_rel e, exam_sub_rel f "
						+ "WHERE b.si_id = c.si_id and c.clcd_id = (select clcd_id from clist_cdetail_rel where cl_id = :cl_id and cd_id = :cd_id) and "
						+ "academic_year = :academic_year and (c.stud_status = 'Active' || c.stud_status = 'Passed' || c.stud_status = 'Failed' || c.stud_status = 'Back' || c.stud_status = 'Repeat') and " 
						+ "c.clcd_id = d.clcd_id and d.cl_id = e.cl_id and e.subcl_id = f.subcl_id and f.exsub_id = :exsub_id and "
						+ "b.si_id not in ( SELECT a.si_id FROM exam_result a, stud_information g, stud_registration h "
						+ "WHERE a.si_id = g.si_id and a.at_id = :at_id and a.fical_year = :academic_year and a.si_id = g.si_id and " 
						+ "h.clcd_id = (select clcd_id from clist_cdetail_rel where cl_id = :cl_id and cd_id = :cd_id) and a.examsub_id = :exsub_id group by si_id )";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year)
				.setParameter("exsub_id", exsub_id)
				.setParameter("at_id", at_id);
		
		return (List<ExamResult>)query.list();
	}

	@Override
	public List<ExamResult> getFilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(int cl_id, int cd_id,
			int exsub_id, int at_id, int academic_year) {

		final String hql = "SELECT a.er_id, a.si_id, b.fname, b.mname, b.gname, a.result, d.pass_mark, d.total_mark " +
				"FROM exam_result a, stud_information b, stud_registration c, exam_sub_rel d " +
				"WHERE a.si_id = b.si_id and a.si_id = c.si_id and a.at_id = :at_id and a.fical_year = :academic_year and c.academic_year = :academic_year and "
				+ "c.clcd_id = (select clcd_id from clist_cdetail_rel where cl_id = :cl_id and cd_id = :cd_id) and a.examsub_id = :exsub_id and "
				+ "a.examsub_id = d.exsub_id and (c.stud_status = 'Active' || c.stud_status = 'Passed' || c.stud_status = 'Failed' || c.stud_status = 'Back' || c.stud_status = 'Repeat')";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", academic_year)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)				
				.setParameter("exsub_id", exsub_id);
		
		return (List<ExamResult>)query.list();
	}

	@Override
	public List<ExamResult> getStudentExamResultWithStudInfoByEr_id(int er_id) {

		final String hql = "SELECT a.er_id, a.result, b.FNAME, b.MNAME, b.GNAME, c.TOTAL_MARK "
				+ "FROM exam_result a, stud_information b, exam_sub_rel c "
				+ "WHERE a.si_id = b.SI_ID and a.examsub_id = c.EXSUB_ID and a.er_id = :er_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql).setParameter("er_id", er_id);
		
		return (List<ExamResult>)query.list();
	}

	@Override
	public List<ExamResult> getStudentsQuarterTotalResultByAcademic_yearAt_idCl_idCd_id(int academic_year, int at_id,
			int cl_id, int cd_id) {

		
		//*** Students total mark per selected quarter ***///
		
		StringBuffer hql = new StringBuffer("");
		
		if(academic_year == Integer.parseInt(ReturnCurrentEthiopianYear.getCurrentEthiopianYear())){
			
			hql = new StringBuffer("SELECT b.si_id, e.fname, e.mname, e.gname, b.at_id, sum(b.result) as total, b.fical_year, c.cl_id, g.cd_id, h.stud_status"
					+ " FROM exam_sub_rel a, exam_result b, subject_class_rel c, subject_list d, stud_information e, clist_cdetail_rel f, class_detail g, stud_registration h"
					+ " WHERE a.exsub_id = b.examsub_id and a.subcl_id = c.subcl_id and c.sub_id = d.sub_id and b.si_id = e.si_id and c.cl_id = f.cl_id and f.cd_id = g.cd_id and e.si_id = h.si_id and f.clcd_id = h.clcd_id and c.cl_id = :cl_id and g.cd_id = cd_id and b.at_id = :at_id and b.fical_year = :academic_year and h.academic_year = :academic_year and c.add_status = 'Yes' and c.convert_to_grade= 'NO' and h.stud_status = 'Active'"
					+ " GROUP BY b.si_id");
		} else {
			
			hql = new StringBuffer("SELECT b.si_id, e.fname, e.mname, e.gname, b.at_id, sum(b.result) as result, b.fical_year, c.cl_id, g.cd_id, h.stud_status"
					+ " FROM exam_sub_rel a, exam_result b, subject_class_rel c, subject_list d, stud_information e, clist_cdetail_rel f, class_detail g, stud_registration h"
					+ " WHERE a.exsub_id = b.examsub_id and a.subcl_id = c.subcl_id and c.sub_id = d.sub_id and b.si_id = e.si_id and c.cl_id = f.cl_id and f.cd_id = g.cd_id and e.si_id = h.si_id and f.clcd_id = h.clcd_id and c.cl_id = :cl_id and g.cd_id = :cd_id and b.at_id = :at_id and b.fical_year = :academic_year and h.academic_year = :academic_year and c.add_status = 'Yes' and c.convert_to_grade= 'NO'"
					+ " GROUP BY b.si_id");
		}
		
		Query query = sessionFactory.openSession().createSQLQuery(hql.toString())
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", academic_year);
				
		return (List<ExamResult>)query.list();
	}

	@Override
	public List<SubjectType> getSubjectNumberAddedOnTotalMarkByCl_id(int cl_id) {

		
		final String numOfSubPerGrade = "SELECT count(sub_id), cl_id FROM subject_class_rel "
										+ "WHERE cl_id = :cl_id and rel_status = 'A' and add_status = 'Yes'";
		
		Query query = sessionFactory.openSession().createSQLQuery(numOfSubPerGrade).setParameter("cl_id", cl_id);
		
		return (List<SubjectType>)query.list();
	}

	@Override
	public List<ExamResult> getEachSubjectTotalMarkListBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id, int at_id,
			int academic_year) {
		
		final String subjectTotal = "SELECT c.SUB_ID, d.SUB_NAME, sum(a.result) sub_total, sum(b.PASS_MARK) pass_mark, sum(b.TOTAL_MARK) total_mark, c.ADD_STATUS, b.EXSUB_ID "
			+ "FROM exam_result a, exam_sub_rel b, subject_class_rel c, subject_list d "
			+ "WHERE a.examsub_id = b.EXSUB_ID and b.SUBCL_ID = c.SUBCL_ID and c.SUB_ID = d.SUB_ID and "
			+ "a.si_id = :si_id and a.fical_year = :academic_year and a.at_id = :at_id and c.CL_ID = :cl_id "
			+ "GROUP BY sub_id "
			+ "ORDER BY add_status DESC, sub_name";
		
		Query query = sessionFactory.openSession().createSQLQuery(subjectTotal)
				.setParameter("si_id", si_id)
				.setParameter("academic_year", academic_year)
				.setParameter("at_id", at_id)
				.setParameter("cl_id", cl_id);
		
		return (List<ExamResult>)query.list();
	}

	@Override
	public List<ExamResult> getSubjectResultPerExamDetailBySi_idAt_idAcademic_year(int si_id, int at_id,
			int academic_year, int sub_id) {

		final String getStudentMarkPerExamType = "SELECT a.er_id, a.result, b.PASS_MARK, b.TOTAL_MARK, d.ET_ID, d.ET_NAME "
				+ "FROM exam_result a, exam_sub_rel b, subject_class_rel c, exams_type d "
				+ "WHERE a.si_id = :si_id and a.fical_year = :academic_year and c.SUB_ID = :sub_id and a.at_id = :at_id and b.ET_ID = d.ET_ID and a.examsub_id = b.EXSUB_ID and b.SUBCL_ID = c.SUBCL_ID and b.REL_STATUS = 'A'";
		
		Query query = sessionFactory.openSession().createSQLQuery(getStudentMarkPerExamType)
				.setParameter("si_id", si_id)
				.setParameter("academic_year", academic_year)
				.setParameter("sub_id", sub_id)
				.setParameter("at_id", at_id);
		
		return (List<ExamResult>)query.list();
	}

	@Override
	public ExamResultComment getTeacherCommentBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id, int at_id,
			int academic_year) {
		
		final String getTeacherComment = "FROM ExamResultComment WHERE si_id = :si_id and cl_id = :cl_id and at_id = :at_id and ac_year = :academic_year";
		
		Query query = sessionFactory.openSession().createQuery(getTeacherComment)
				.setParameter("si_id", si_id)
				.setParameter("cl_id", cl_id)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", academic_year);
		
		List<ExamResultComment> teachersComment = (List<ExamResultComment>)query.list();
		
		ExamResultComment comment = new ExamResultComment();
		
		for(int i = 0; i < teachersComment.size(); i++){
			
			comment.setErc_id(teachersComment.get(i).getErc_id());
			comment.setErc_content(teachersComment.get(i).getErc_content());
		}
		
		return comment;
	}

	@Override
	public List<ExamResult> getStudentQuarterResultViewBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id,
			int at_id, int academic_year) {
		
		final String getStudQuarterResult = "SELECT distinct b.si_id, e.fname, e.mname, e.gname, b.at_id, b.examsub_id, f.at_name, d.sub_id, d.sub_name, c.add_status, c.convert_to_grade,(b.result) finalExam, b.fical_year, c.cl_id, c.SUBCL_ID, AA.cummulative"
				+ " FROM exam_result b, subject_class_rel c, subject_list d, stud_information e, annual_terms f, stud_registration g, exam_sub_rel a left join ("
				+ " 	SELECT sum(i.result) cummulative, h.subcl_id "
				+ " 	FROM exam_sub_rel h, exam_result i "
				+ " 	WHERE h.exsub_id = i.examsub_id and i.si_id = :si_id and i.at_id = :at_id and h.et_id <> (select max(et_id) from exams_type where et_status = 'A') and i.fical_year = :academic_year"
				+ " 	Group by h.subcl_id"
				+ " ) AA using (subcl_id)"
				+ " WHERE e.si_id = g.si_id and a.et_id = (select max(et_id) from exams_type where et_status = 'A') and a.exsub_id = b.examsub_id and a.subcl_id = c.subcl_id and c.sub_id = d.sub_id and b.si_id = e.si_id and f.at_id = b.at_id and b.si_id = :si_id and b.at_id = :at_id and b.fical_year = :academic_year and c.cl_id = :cl_id"
				+ " ORDER BY c.convert_to_grade, d.sub_name";
		
		Query query = sessionFactory.openSession().createSQLQuery(getStudQuarterResult)
				.setParameter("si_id", si_id)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", academic_year)
				.setParameter("si_id", si_id)
				.setParameter("at_id", at_id)
				.setParameter("academic_year", academic_year)
				.setParameter("cl_id", cl_id);
		
		return (List<ExamResult>)query.list();
	}

	@Override
	public boolean getExaminationDateValidation(int examsub_id, int academic_year) {
		
		final String getSubjectExamDate = "SELECT es_greg_date " +
				                          "FROM exam_schedule c, (SELECT a.et_id, b.sub_id, b.cl_id  FROM exam_sub_rel a, subject_class_rel b WHERE exsub_id = :examsub_id and a.subcl_id = b.subcl_id and a.rel_status = 'A') d " +
				                          "WHERE c.et_id = d.et_id and c.sub_id = d.sub_id and c.cl_id = d.cl_id and c.es_status = 'A' and c.es_fiscalyear = :academic_year";
		
		Query query = sessionFactory.openSession().createSQLQuery(getSubjectExamDate)
				.setParameter("examsub_id", examsub_id)
				.setParameter("academic_year", academic_year);
		
		List<ExamSchedule> examScheduleDate = (List<ExamSchedule>)query.list();
		
		String examSchDate = "";
		
		for(int i = 0; i < examScheduleDate.size(); i++){
			
			examSchDate = String.valueOf(examScheduleDate.get(i));
		}
		
		try{
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Date examDate = sdf.parse(examSchDate);
			Date dt = new Date();
			String td = sdf.format(dt);
			Date today = sdf.parse(td);
			
			if(today.compareTo(examDate) > 0){
				
				return true;
			}
		}catch(Exception ex){
			
		}
		
		return false;
	}

	@Override
	public DAAttendance getStudentAbsentDayList(int si_id, int at_id, int academic_year) {
		
		return null;
	}

	@Override
	public String getHomeroomTeacherName(int cl_id, int cd_id, int academic_year) {
		
		final String getHomeroomTeachersName = "SELECT b.fname, b.mname, b.gname FROM tech_hroom_assignment a, teacher_information b WHERE a.ti_id = b.ti_id and a.cl_id = :cl_id and a.cd_id = :cd_id and a.academic_year = :academic_year and thra_status = 'A'";
		
		Query query = sessionFactory.openSession().createSQLQuery(getHomeroomTeachersName)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		List<TeacherInformation> homeRoomTeacher = (List<TeacherInformation>)query.list();
		
		StringBuffer fullName = new StringBuffer("");
		
		for(Object obj : homeRoomTeacher){
			
			Object[] fields = (Object[])obj;
			
			fullName = new StringBuffer(fields[0] + " " + fields[1] + " " + fields[2]);
		}
		
		return fullName.toString();
	}

	@Override
	public List<ExamResult> getStudentTotalResultPerEachQuarter(int cl_id, int cd_id, int academic_year) {
		System.out.println("in");
		final String getStudentTotalRsltPerEachQuarter = "SELECT rsltlist.qrt_total, sublist.si_id, sublist.fname, sublist.mname, sublist.gname, sublist.at_id, rsltlist.stud_status " 
				+ "FROM "
				+ "(SELECT distinct d.si_id, f.at_id, g.fname, g.mname, g.gname, g.sex, g.dob "
				+ "FROM subject_list a, subject_class_rel b, stud_registration d, clist_cdetail_rel e, annual_terms f, stud_information g "
				+ "WHERE a.sub_id = b.sub_id and e.cl_id = :cl_id and e.CD_ID = :cd_id and b.SUBCL_ID in (select subcl_id from exam_sub_rel where SUBCL_ID in (select subcl_id from subject_class_rel where CL_ID = :cl_id)) and b.CL_ID = e.CL_ID and sub_status = 'A' and d.si_id = g.si_id and d.CLCD_ID = e.CLCD_ID and d.ACADEMIC_YEAR = :academic_year and "
					+ "(d.stud_status = 'Active' || d.stud_status = 'Passed' || d.stud_status = 'Failed' || d.stud_status = 'Back' || d.stud_status = 'Repeat')) as sublist " 
				+ "LEFT JOIN "
				+ "(SELECT sum(a.result) as qrt_total, a.si_id, a.at_id, d.FNAME, d.MNAME, d.GNAME, e.STUD_STATUS "
				+ "FROM exam_result a, exam_sub_rel b, subject_class_rel c, stud_information d, stud_registration e, subject_list f "
				+ "WHERE e.CLCD_ID = (select CLCD_ID from clist_cdetail_rel where cl_id = :cl_id and cd_id = :cd_id) and c.add_status = 'Yes' and a.fical_year = :academic_year and f.SUB_ID = c.SUB_ID and d.si_id = e.si_id and e.ACADEMIC_YEAR = :academic_year and c.subcl_id = b.subcl_id and a.si_id = d.si_id and b.exsub_id = a.examsub_id " 
				+ "GROUP BY a.si_id, a.at_id) as rsltlist "
				+ "USING (si_id, at_id) "
				+ "ORDER BY sublist.si_id, sublist.at_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(getStudentTotalRsltPerEachQuarter)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		List<ExamResult> rslt = (List<ExamResult>)query.list();
		System.out.println(rslt.size());
		
		///*** Filtering students list ***///
		List<ExamResult> studlist = new ArrayList<ExamResult>();
		
		int prev_si_id = 0;
				
		for(Object obj : rslt){
			
			Object[] fields = (Object[])obj;
			
			int counter = 0;
			
			if(prev_si_id != 0 && Integer.parseInt(fields[1].toString()) == prev_si_id){
							
				counter++;				
			}
			
			if(counter == 0){
				
				prev_si_id = Integer.parseInt(fields[1].toString());
						
				ExamResult exrslt = new ExamResult();
				
				exrslt.setSi_id(Integer.parseInt(fields[1].toString()));
				
				StudentInformation studInfo = new StudentInformation();
				studInfo.setFname(fields[2].toString());
				studInfo.setMname(fields[3].toString());
				studInfo.setGname(fields[4].toString());
				exrslt.setStudentInformation(studInfo);
				
				exrslt.setStudentResultStatus(fields[6] == null?"":fields[6].toString());
				
				studlist.add(exrslt);
			}
		}
		///*** END - Filtering students list ***///
		
		
		///*** Getting number of subject per selected grade ***///
		final String numOfSubPerGrade = "SELECT count(sub_id) FROM subject_class_rel WHERE cl_id = :cl_id and rel_status = 'A' and add_status = 'Yes'";
		
		query = sessionFactory.openSession().createSQLQuery(numOfSubPerGrade)
				.setParameter("cl_id", cl_id);
		
		List<SubjectClassRelation> subjectClassRelCount = (List<SubjectClassRelation>)query.list();
		
		int numOfSub = 1;
		
		for(Object obj : subjectClassRelCount){
			
			numOfSub = Integer.parseInt(String.valueOf(obj));
		}
		///*** END - Getting number of subject per selected grade ***///

		
		///*** Organizing the students quarter mark ***///
		List<ExamResult> organizedrslt = new ArrayList<ExamResult>();
						
		for(int i = 0; i < studlist.size(); i++){
			
			ExamResult exb = new ExamResult();
			
			exb.setSi_id(studlist.get(i).getSi_id());
			
			StudentInformation studInfo = new StudentInformation();
			studInfo.setFname(studlist.get(i).getStudentInformation().getFname());
			studInfo.setMname(studlist.get(i).getStudentInformation().getMname());
			studInfo.setGname(studlist.get(i).getStudentInformation().getGname());
			exb.setStudentInformation(studInfo);
			
			exb.setStudentResultStatus(studlist.get(i).getStudentResultStatus());
					
			int sem_num = 0;
					
			for(Object obj : rslt){
				
				Object[] fields = (Object[])obj;
				
				if(Integer.parseInt(fields[1].toString()) == studlist.get(i).getSi_id()){
							
					if(Integer.parseInt(fields[5].toString()) == 1){
								
						exb.setQuarter_one_total(fields[0]==null?0.0:Double.parseDouble(fields[0].toString()));
						
						if(exb.getQuarter_one_total() != 0.0){
							
							sem_num++;
						}
					}					
					if(Integer.parseInt(fields[5].toString()) == 2){
								
						exb.setQuarter_two_total(fields[0]==null?0.0:Double.parseDouble(fields[0].toString()));
								
						if(exb.getQuarter_two_total() != 0.0){
					
							sem_num++;
						}
					}
					if(Integer.parseInt(fields[5].toString()) == 3){
						
						exb.setQuarter_three_total(fields[0]==null?0.0:Double.parseDouble(fields[0].toString()));
								
						if(exb.getQuarter_three_total() != 0.0){
			
							sem_num++;
						}
					}
					if(Integer.parseInt(fields[5].toString()) == 4){
								
						exb.setQuarter_four_total(fields[0]==null?0.0:Double.parseDouble(fields[0].toString()));
								
						if(exb.getQuarter_four_total() != 0.0){
			
							sem_num++;
						}
					}
				}
			}
					
			//>> in case if it returns 0
			if(sem_num == 0){
	
				sem_num = 1;
			}
			
			double total_mark = exb.getQuarter_one_total() + exb.getQuarter_two_total() + exb.getQuarter_three_total() + exb.getQuarter_four_total();
					
			exb.setTotal_mark(total_mark);
			
			Double yr_avg = (total_mark/numOfSub)/sem_num;
			
			exb.setAverage_quarter_mark(yr_avg);
					
			organizedrslt.add(exb);
		}
		///*** END - Organizing the students quarter mark ***///
		
		return organizedrslt;
	}

	@Override
	public List<ExamResult> getSummerizedStudCountPerMarkInserted(int at_id, int academic_year, int et_id, int cl_id,
			int cd_id) {

		final String getSummerizedStudCountPerMarkInserted = "SELECT a.examsub_id, f.SUB_NAME, COUNT(a.si_id) AS stud_count "
				+ " FROM sms_everest.exam_result a, exam_sub_rel d, subject_class_rel e, subject_list f "
				+ " WHERE a.fical_year = :academic_year AND a.at_id = :at_id"
				+ " AND a.examsub_id IN (SELECT b.exsub_id FROM exam_sub_rel b WHERE b.ET_ID = :et_id AND b.SUBCL_ID IN (SELECT c.SUBCL_ID FROM subject_class_rel c WHERE c.CL_ID = :cl_id)) "
				+ " AND a.si_id IN (SELECT g.si_id FROM stud_registration g WHERE g.ACADEMIC_YEAR = :academic_year AND g.STUD_STATUS = 'Active' "
				+ " AND g.CLCD_ID IN (SELECT h.CLCD_ID FROM clist_cdetail_rel h WHERE h.cl_id = :cl_id AND h.cd_id = :cd_id))"
				+ " AND a.examsub_id = d.EXSUB_ID AND d.SUBCL_ID = e.SUBCL_ID AND f.SUB_ID = e.SUB_ID GROUP BY examsub_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(getSummerizedStudCountPerMarkInserted)
				.setParameter("academic_year", academic_year)
				.setParameter("at_id", at_id)
				.setParameter("et_id", et_id)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id);
		
		return (List<ExamResult>)query.list();
	}

}
