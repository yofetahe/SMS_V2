package com.fidel.sms.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.StudentDao;
import com.fidel.sms.model.StudentCurrentAddress;
import com.fidel.sms.model.StudentDisciplinaryAction;
import com.fidel.sms.model.StudentEmergencyContact;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.StudentPhotoInformation;
import com.fidel.sms.model.StudentRegistration;
import com.fidel.sms.model.StudentReward;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public StudentDaoImpl(){}
	
	public StudentDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StudentInformation> stud_db_persex() {
		
		final String getCurrentYearStudentNoPerSex = "SELECT class_name, male, female FROM v_current_year_students_num_per_grade";
		
		Query query = sessionFactory.openSession().createSQLQuery(getCurrentYearStudentNoPerSex);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getStudentNumPerClass(int academic_year) {

		final String getStudentNumPerClassSex = "SELECT class_name, cl_id, male, female FROM v_student_num_per_class_sex_and_year WHERE academic_year = :academic_year ORDER BY cl_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(getStudentNumPerClassSex).setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getStudentCountPerGradeDetail(StudentRegistration studInfo) {

		final String getStudentNumberPerCDetailAndSex = "SELECT class_name, cd_name, male, female FROM v_student_num_per_class_cdetail_sex_and_year WHERE cl_id = :cl_id and academic_year = :academic_year ";
		
		Query query = sessionFactory.openSession().createSQLQuery(getStudentNumberPerCDetailAndSex)
				.setParameter("academic_year", studInfo.getAcademic_year())
				.setParameter("cl_id", studInfo.getClcdRelation().getClassType().getCl_id());
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getStudentListPerGradeDetail(int cl_id, int cd_id, int academic_year) {
		
		final String studentListPerClassDetail = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, a.photo_path, a.photo_name " +
					"FROM stud_information a, clist_cdetail_rel b, stud_registration c " +
					"WHERE a.si_id = c.si_id and c.clcd_id = b.clcd_id and b.clcd_id = (SELECT clcd_id FROM clist_cdetail_rel WHERE cl_id = :cl_id and cd_id = :cd_id) and c.academic_year = :academic_year and (c.stud_status = 'Active' || c.stud_status = 'Passed' || c.stud_status = 'Failed' || c.stud_status = 'Back' || c.stud_status = 'Repeat') and a.si_status = 'A' "
					+ "ORDER BY a.fname, a.mname, a.gname";
		
		Query query = sessionFactory.openSession().createSQLQuery(studentListPerClassDetail)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)				
				.setParameter("academic_year", "2009");
		
		return (List<StudentInformation>)query.list();		
	}
	
	@Override
	public List<StudentInformation> getStudentsListPerGrade(int cl_id, int academic_year) {
		
		final String studentListPerClassDetail = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, a.photo_path, a.photo_name, b.cd_id " +
					"FROM stud_information a, clist_cdetail_rel b, stud_registration c " +
					"WHERE a.si_id = c.si_id and c.clcd_id = b.clcd_id and b.clcd_id in (SELECT clcd_id FROM clist_cdetail_rel WHERE cl_id = :cl_id) and c.academic_year = :academic_year and (c.stud_status = 'Active' || c.stud_status = 'Passed' || c.stud_status = 'Failed' || c.stud_status = 'Back' || c.stud_status = 'Repeat') and a.si_status = 'A' "
					+ "ORDER BY b.cd_id, a.fname, a.mname, a.gname";
		
		Query query = sessionFactory.openSession().createSQLQuery(studentListPerClassDetail)
				.setParameter("cl_id", cl_id)				
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();		
	}

	@Override
	public StudentInformation getStudentInformationById(int si_id) {
		
		final String stud_info = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, b.stud_status, a.photo_path, a.photo_name " +
			 					"FROM stud_information a, stud_registration b WHERE a.si_id = b.si_id and a.si_id = :si_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(stud_info).setParameter("si_id", si_id);
		
		List<StudentInformation> rslt = (List<StudentInformation>)query.list();
		
		StudentInformation studInfo = new StudentInformation();
		
		for(Object obj : rslt){
			
			Object[] feild = (Object[])obj;
			
			studInfo.setSi_id(Integer.parseInt(feild[0].toString()));
			studInfo.setFname(feild[1].toString());
			studInfo.setMname(feild[2].toString());
			studInfo.setGname(feild[3].toString());
			studInfo.setSex(feild[5].toString());
			studInfo.setDob(feild[6].toString());
			studInfo.setPob(feild[7].toString());
			studInfo.setMother_name(feild[4].toString());
			studInfo.setNationality(feild[8].toString());
			studInfo.setId_no(feild[9].toString());
			studInfo.setSi_status(feild[10].toString());
			
			StudentRegistration studReg = new StudentRegistration();
			studReg.setStud_status(feild[11].toString());
			studInfo.setStudRegistration(studReg);
		}
		
		return studInfo;
	}

	@Override
	public byte[] getStudentPhotoBySiid(int si_id) {

		final String getStudentPhoto = "FROM StudentPhotoInformation WHERE si_id = :si_id";
		
		Query query = sessionFactory.openSession().createQuery(getStudentPhoto).setParameter("si_id", si_id);
		
		List<StudentPhotoInformation> studPhoto = (List<StudentPhotoInformation>)query.list();
		
		byte[] rslt = null;
		
		if(studPhoto.size() > 0){

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			byte[] buf = new byte[1024];
			
			byte[] pic = studPhoto.get(0).getStud_photo();
			
			InputStream in;
			
			try {
				
				Blob b = new SerialBlob(pic);
				
				in = b.getBinaryStream();
			
				int n = 0;
				
				while((n = in.read(buf)) >= 0){
					
					baos.write(buf, 0, n);
				}
				
				in.close();
				
				rslt = baos.toByteArray();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return rslt;
	}

	@Override
	public List<StudentEmergencyContact> getStudentContactInformationListPerGradeDetail(int cl_id, int cd_id,
			int academic_year) {
		
		final String studentContactInfoListPerClassDetail = "SELECT a.si_id, a.fname, a.mname, a.gname, a.sex, b.cont_name, b.relationship, b.mob_no "
				+"FROM stud_registration c, stud_information a LEFT JOIN stud_emergency_contact b ON a.si_id = b.si_id "
				+"WHERE b.sec_status = 'A' and a.si_status = 'A' and a.si_id = c.si_id and c.clcd_id = (select clcd_id from clist_cdetail_rel where cl_id = :cl_id and cd_id = :cd_id) and c.academic_year = :academic_year "
				+"ORDER BY a.fname, a.mname, a.gname";
		
		Query query = sessionFactory.openSession().createSQLQuery(studentContactInfoListPerClassDetail)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)				
				.setParameter("academic_year", academic_year);
		
		return (List<StudentEmergencyContact>)query.list();
	}
	
	@Override
	public List<StudentInformation> getAllStudentInformationPerSelectedAcademicYear(int academic_year) {
		
		final String allStudentList = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, a.photo_path, a.photo_name " 
				+ "FROM stud_information a "
				+ "WHERE a.si_id in (select b.si_id from stud_registration b where b.academic_year = :academic_year and (b.stud_status = 'Active' or b.stud_status = 'Passed' or b.stud_status = 'Failed' or b.stud_status = 'Back' or b.stud_status = 'Repeat'))";
		
		Query query = sessionFactory.openSession().createSQLQuery(allStudentList)
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getAllInactiveStudentInformationPerSelectedAcademicYear(int academic_year) {
		
		final String allStudentList = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, a.photo_path, a.photo_name " 
				+ "FROM stud_information a "
				+ "WHERE a.si_status = 'I' and a.si_id in (select b.si_id from stud_registration b where b.academic_year = :academic_year and (b.stud_status <> 'Active' and b.stud_status <> 'Passed' and b.stud_status <> 'Failed' and b.stud_status <> 'Back' and b.stud_status <> 'Repeat'))";
		
		Query query = sessionFactory.openSession().createSQLQuery(allStudentList)
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getAllNewCandidateStudentInformation() {
		
		final String allStudentList = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, a.photo_path, a.photo_name " 
				+ "FROM stud_information a "
				+ "WHERE a.si_id not in (select si_id from stud_registration)";
		
		Query query = sessionFactory.openSession().createSQLQuery(allStudentList);
		
		return (List<StudentInformation>)query.list();
	}
	
	
	
	///*** STUDENT REGISTRATION ***///
	
	@Override
	public List<StudentInformation> getStudentsListForRegistration(int cl_id, int academic_year) {
		
		final String getNewStudList = "SELECT si_id, fname, mname, gname, mother_name, sex, dob, pob, id_no, si_status, 'New' as status "
				+ "FROM stud_information "
				+ "WHERE si_id not in (select si_id from stud_registration) and si_status = 'A'"
				+ "UNION " 
				+ "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.id_no, a.si_status, ('Failed/Repeat') as 'status' "
				+ "FROM stud_information a, stud_registration b, clist_cdetail_rel c "
				+ "WHERE a.si_id = b.si_id and b.clcd_id = c.clcd_id and((b.stud_status = 'Failed' or b.stud_status = 'Repeat' or b.stud_status = 'DropOut') and c.cl_id = :cl_id) and a.si_status = 'A' and b.academic_year = :academic_year "
				+ "UNION "
				+ "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.id_no, a.si_status, ('Return') as 'status' "
				+ "FROM stud_information a, stud_registration b, clist_cdetail_rel c "
				+ "WHERE a.si_id = b.si_id and b.stud_status = 'Back' and c.clcd_id = b.clcd_id and c.cl_id > :cl_id and a.si_id not in (select si_id from stud_registration where stud_status = 'Active' and academic_year = :academic_year)";
		
		final String getStudList = "SELECT si_id, fname, mname, gname, ('New') as 'status'  " +
				"FROM stud_information " +
				"WHERE si_id not in (select si_id from stud_registration) and si_status = 'A' " +
				"UNION " +
				"SELECT a.si_id, a.fname, a.mname, a.gname, ('Passed') as 'status' " +
				"FROM stud_information a, stud_registration b, clist_cdetail_rel c " +
				"WHERE a.si_id = b.si_id and b.clcd_id = c.clcd_id and (b.stud_status = 'Passed' and c.cl_id = :previous_cl and b.academic_year = :last_year and a.si_id not in (select si_id from stud_registration where stud_status = 'Active' and academic_year = :academic_year)) and a.si_status = 'A' " +
				"UNION " +
				"SELECT a.si_id, a.fname, a.mname, a.gname, ('Failed/Repeat') as 'status' " +
				"FROM stud_information a, stud_registration b, clist_cdetail_rel c " +
				"WHERE a.si_id = b.si_id and b.clcd_id = c.clcd_id and((b.stud_status = 'Failed' or b.stud_status = 'Repeat') and c.cl_id = :cl_id) and a.si_status = 'A' and (b.academic_year = :last_year or b.academic_year = :last_year) and a.si_id not in (select si_id from stud_registration where (stud_status = 'Active' or stud_status = 'Passed') and academic_year = :last_year) " +
				"UNION " +
				"SELECT si_id, fname, mname, gname, ('Return') as 'status' " +
				"FROM stud_information " +
				"WHERE si_id in (select si_id from stud_registration where stud_status = 'DropOut') " +
				"and si_id not in (select si_id from stud_registration where stud_status = 'Active' and academic_year = :academic_year) and si_status = 'A'";
		
		int prev_cl = cl_id - 1;
		int last_year = academic_year - 1;
		
		if(cl_id == 1){
		
			Query query = sessionFactory.openSession().createSQLQuery(getNewStudList)
					.setParameter("cl_id", cl_id)
					.setParameter("academic_year", academic_year)
					.setParameter("cl_id", cl_id)
					.setParameter("academic_year", academic_year);			
			
			return (List<StudentInformation>)query.list();
			
		} else {
			
			Query query = sessionFactory.openSession().createSQLQuery(getStudList)
					.setParameter("previous_cl", prev_cl)//passed
					.setParameter("last_year", last_year)//passed
					.setParameter("academic_year", academic_year)//passed
					.setParameter("cl_id", cl_id)//failed
					.setParameter("last_year", last_year)
					.setParameter("last_year", last_year)
					.setParameter("last_year", last_year)
					.setParameter("academic_year", academic_year);//return
			
			return (List<StudentInformation>)query.list();
		}		
	}
	
	
	
	
	
	///*** STUDENT CURRENT ADDRESS ***///
	
	@Override
	public List<StudentCurrentAddress> getStudentCurrentAddressBySiid(int si_id) {
		
		final String getStudentCurrrentAddress = "FROM StudentCurrentAddress a WHERE a.si_id = :si_id";
		
		Query query = sessionFactory.openSession().createQuery(getStudentCurrrentAddress)
				.setParameter("si_id", si_id);
		
		return (List<StudentCurrentAddress>)query.list();
	}

	///*** END - STUDENT CURRENT ADDRESS ***///
	
	
	
	
	///*** EMERGENCY CONTACT ***///
	
	@Override
	public List<StudentEmergencyContact> getStudentEmergencyContactBySiid(int si_id) {
		
		final String getStudentContactList = "FROM StudentEmergencyContact a WHERE a.si_id = :si_id";

		Query query = sessionFactory.openSession().createQuery(getStudentContactList)
				.setParameter("si_id", si_id);
		
		return (List<StudentEmergencyContact>)query.list();
	}

	@Override
	public StudentEmergencyContact getStudentEmergencyContactBySecid(int sec_id) {
		
		final String getStudentContactList = "FROM StudentEmergencyContact a WHERE a.sec_id = :sec_id";

		Query query = sessionFactory.openSession().createQuery(getStudentContactList)
				.setParameter("sec_id", sec_id);
		
		List<StudentEmergencyContact> rslt = (List<StudentEmergencyContact>)query.list();
		
		StudentEmergencyContact emregContact = new StudentEmergencyContact();
		
		for(StudentEmergencyContact ec : rslt){
			
			emregContact.setSec_id(sec_id);
			emregContact.setCont_name(ec.getCont_name());
			emregContact.setRelationship(ec.getRelationship());
			emregContact.setMob_no(ec.getMob_no());
			emregContact.setOffice_phone_no(ec.getOffice_phone_no());
			emregContact.setHome_phone_no(ec.getHome_phone_no());
			emregContact.setSec_status(ec.getSec_status());
			emregContact.setSi_id(ec.getSi_id());
		}
		
		return emregContact;
	}

	///*** END - EMERGENCY CONTACT ***///
	
	
	
	
	///*** STUDENT REWARD ***///
	
	@Override
	public List<StudentReward> getStudentRewardListBySiid(int si_id) {
		
		final String getStudentRewardList = "FROM StudentReward a WHERE a.si_id = :si_id";

		Query query = sessionFactory.openSession().createQuery(getStudentRewardList)
				.setParameter("si_id", si_id);
		
		return (List<StudentReward>)query.list();
	}

	@Override
	public StudentReward getStudentRewardBySrid(int sr_id) {
		
		final String getStudentReward = "FROM StudentReward a WHERE a.sr_id = :sr_id";

		Query query = sessionFactory.openSession().createQuery(getStudentReward)
				.setParameter("sr_id", sr_id);
		
		List<StudentReward> rslt = (List<StudentReward>)query.list();
		
		StudentReward reward = new StudentReward();
		
		for(StudentReward ec : rslt){
			
			reward.setSr_id(sr_id);
			reward.setSi_id(ec.getSi_id());
			reward.setSr_date(ec.getSr_date());
			reward.setSr_reason(ec.getSr_reason());
			reward.setSr_type(ec.getSr_type());
			reward.setSr_status(ec.getSr_status());
		}
		
		return reward;
	}

	///*** END - STUDENT REWARD ***///
	
	
	
	///*** STUDENT DISCIPLINARY ACTION ***///
	
	@Override
	public List<StudentDisciplinaryAction> getStudentDisciplinaryActionListBySiid(int si_id) {
		
		final String getStudentRewardList = "FROM StudentDisciplinaryAction a WHERE a.si_id = :si_id";

		Query query = sessionFactory.openSession().createQuery(getStudentRewardList)
				.setParameter("si_id", si_id);
		
		return (List<StudentDisciplinaryAction>)query.list();
	}

	@Override
	public StudentDisciplinaryAction getStudentDisciplinaryActionBySdaid(int sda_id) {
		
		final String getStudentReward = "FROM StudentDisciplinaryAction a WHERE a.sda_id = :sda_id";

		Query query = sessionFactory.openSession().createQuery(getStudentReward)
				.setParameter("sda_id", sda_id);
		
		List<StudentDisciplinaryAction> rslt = (List<StudentDisciplinaryAction>)query.list();
		
		StudentDisciplinaryAction disact = new StudentDisciplinaryAction();
		
		for(StudentDisciplinaryAction ec : rslt){
			
			disact.setSda_id(sda_id);
			disact.setSda_type(ec.getSda_type());
			disact.setSda_reason(ec.getSda_reason());
			disact.setSda_date(ec.getSda_date());
			disact.setSda_status(ec.getSda_status());
		}
		
		return disact;
	}
	
	///*** END - STUDENT DISCIPLINARY ACTION ***///
	
	
	
	///*** ADMIN - ID CARD GENERATION ***///

	@Override
	public List<StudentInformation> getStudListWithIDPerGradeDetail(int cl_id, int cd_id, int academic_year) {
		
		final String hql = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, c.stud_status, a.photo_path, a.photo_name " +
				"FROM stud_information a, clist_cdetail_rel b, stud_registration c " +
				"WHERE a.si_id = c.si_id and c.clcd_id = b.clcd_id and b.clcd_id = (SELECT clcd_id FROM clist_cdetail_rel WHERE cl_id = :cl_id and cd_id = :cd_id) and c.academic_year = :academic_year and c.stud_status = 'Active' and a.si_id in (SELECT si_id FROM stud_id_card WHERE sid_status = 'Active') "
				+ "ORDER BY a.fname, a.mname, a.gname";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getStudListWithoutIDPerGradeDetail(int cl_id, int cd_id, int academic_year) {
		
		final String hql = "SELECT distinct a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, c.stud_status, a.photo_path, a.photo_name, d.class_name, f.stud_photo, g.cd_name "
				+"FROM clist_cdetail_rel b, stud_registration c, class_list d, student_photo_information f, stud_information a, stud_emergency_contact e, class_detail g "
				+"WHERE a.si_id = c.si_id and b.cl_id = d.cl_id and c.clcd_id = b.clcd_id and b.cd_id = g.cd_id and a.si_id = e.si_id and b.clcd_id = (SELECT clcd_id FROM clist_cdetail_rel WHERE cl_id = :cl_id and cd_id = :cd_id) and c.academic_year = :academic_year and c.stud_status = 'Active' and a.si_id not in (SELECT si_id FROM stud_id_card WHERE sid_status = 'Active') and a.si_id = f.si_id "
				+"ORDER BY a.fname, a.mname, a.gname";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getStudentListWithoutPhotoByCl_idCd_idAcadmic_year(int cl_id, int cd_id,
			int academic_year) {
		
		final String hql = "SELECT a.si_id, concat(a.fname, ' ', a.mname, ' ', a.gname), a.sex, b.cont_name, b.relationship, b.mob_no "
				+"FROM stud_registration c, stud_information a LEFT JOIN stud_emergency_contact b ON a.si_id = b.si_id "
				+"WHERE a.si_id = c.si_id and c.clcd_id = (select clcd_id from clist_cdetail_rel where cl_id = :cl_id and cd_id = :cd_id) and c.academic_year = :academic_year and a.si_id not in (select si_id from student_photo_information)";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getStudentWithoutContactInfoByCl_idCd_idAcadmic_year(int cl_id, int cd_id,
			int academic_year) {

		final String hql = "SELECT a.si_id, a.fname, a.mname, a.gname, a.sex, '' as cont_name, '' as relationship, '' as mob_no "
				+"FROM stud_registration c, stud_information a "
				+"WHERE a.si_id = c.si_id and c.clcd_id = (select clcd_id from clist_cdetail_rel where cl_id = :cl_id and cd_id = :cd_id) and c.academic_year = :academic_year and a.si_id not in (select si_id from stud_emergency_contact)";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}
	
	///*** END - ADMIN - ID CARD GENERATION ***///
	
	
	
	///*** ADMIN - Special Registration ***///

	@Override
	public List<StudentInformation> getUnregistedStudentListPerGradeDetailForSpecialReg(int cl_id, int cd_id,
			int academic_year) {
		
		final String hql = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, c.stud_status, a.photo_path, a.photo_name " +
				"FROM stud_information a, clist_cdetail_rel b, stud_registration c " +
				"WHERE a.si_id = c.si_id and c.clcd_id = b.clcd_id and b.clcd_id = (SELECT clcd_id FROM clist_cdetail_rel WHERE cl_id = :cl_id and cd_id = :cd_id) and c.academic_year = :academic_year and c.stud_status = 'Active' and c.eduoff_reg <> 'A' "
				+ "ORDER BY a.fname, a.mname, a.gname";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}

	@Override
	public List<StudentInformation> getRegisteredStudentListPerGradeDetailForSpecialReg(int cl_id, int cd_id,
			int academic_year) {

		final String hql = "SELECT a.si_id, a.fname, a.mname, a.gname, a.mother_name, a.sex, a.dob, a.pob, a.nationality, a.id_no, a.si_status, c.stud_status, a.photo_path, a.photo_name " +
				"FROM stud_information a, clist_cdetail_rel b, stud_registration c " +
				"WHERE a.si_id = c.si_id and c.clcd_id = b.clcd_id and b.clcd_id = (SELECT clcd_id FROM clist_cdetail_rel WHERE cl_id = :cl_id and cd_id = :cd_id) and c.academic_year = :academic_year and c.stud_status = 'Active' and c.eduoff_reg = 'A' "
				+ "ORDER BY a.fname, a.mname, a.gname";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		return (List<StudentInformation>)query.list();
	}
	
	///*** END - ADMIN - Special Registration ***///
	
	
	

	@Override
	public int getStudentNumberPerClassDetail(int cl_id, int cd_id, int academic_year) {
		
		final String getNumOfStudPerClassDetail = "SELECT count(si_id) "+ 
				"FROM stud_registration a,  clist_cdetail_rel b " +
				"WHERE a.clcd_id = b.clcd_id and b.cl_id = :cl_id and b.cd_id = :cd_id and (a.academic_year = :academic_year and (a.stud_status = 'Active' || a.stud_status = 'Passed' || a.stud_status = 'Failed' || a.stud_status = 'Back' || a.stud_status = 'Repeat'))";
		
		Query query = sessionFactory.openSession().createSQLQuery(getNumOfStudPerClassDetail)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id)
				.setParameter("academic_year", academic_year);
		
		List<StudentInformation> list = (List<StudentInformation>)query.list();
		
		for(Object obj : list){
			
			return Integer.parseInt(String.valueOf(obj));
		}
		
		return 0;
	}

	@Override
	public List<StudentInformation> searchStudentByCl_idCd_idName(int cl_id, int cd_id, String searchName) {
		
		final String hql = "SELECT a.si_id, a.FNAME, a.MNAME, a.GNAME FROM stud_information a, stud_registration b WHERE a.SI_ID = b.SI_ID and b.CLCD_ID = (select CLCD_ID from clist_cdetail_rel where CL_ID = :cl_id and cd_id = :cd_id) and a.FNAME like '" + searchName + "%'";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("cl_id", cl_id)
				.setParameter("cd_id", cd_id);
		
		return (List<StudentInformation>)query.list();
	}
}
