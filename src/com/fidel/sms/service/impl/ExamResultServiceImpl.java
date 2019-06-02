package com.fidel.sms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.ExamResultDao;
import com.fidel.sms.model.DAAttendance;
import com.fidel.sms.model.ExamResult;
import com.fidel.sms.model.ExamResultComment;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.service.ExamResultService;

@Service
public class ExamResultServiceImpl implements ExamResultService {
	
	@Autowired
	ExamResultDao examResultDao;

	@Override
	public List<ExamResult> getUnfilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(int cl_id, int cd_id,
			int exsub_id, int at_id, int academic_year) {
		
		return examResultDao.getUnfilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(cl_id, cd_id, exsub_id, at_id, academic_year);
	}

	@Override
	public List<ExamResult> getFilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(int cl_id, int cd_id,
			int exsub_id, int at_id, int academic_year) {
		
		return examResultDao.getFilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(cl_id, cd_id, exsub_id, at_id, academic_year);
	}

	@Override
	public List<ExamResult> getStudentExamResultWithStudInfoByEr_id(int er_id) {
		
		return examResultDao.getStudentExamResultWithStudInfoByEr_id(er_id);
	}

	@Override
	public List<ExamResult> getStudentsQuarterTotalResultByAcademic_yearAt_idCl_idCd_id(int academic_year, int at_id,
			int cl_id, int cd_id) {
		
		
		///*** Getting subject number to calculate average mark ***///
		int sub_number = 1;
		
		List<SubjectType> subjectNumber = examResultDao.getSubjectNumberAddedOnTotalMarkByCl_id(cl_id);
		
		for(Object obj : subjectNumber){
			
			Object[] feilds = (Object[])obj;
			
			sub_number = Integer.parseInt(feilds[0].toString());
		}
		///*** END - Getting subject number to calculate average mark ***///
		
		
		
		///*** Generate student quarter result list ***///
		List<ExamResult> studentQuarterResult = examResultDao.getStudentsQuarterTotalResultByAcademic_yearAt_idCl_idCd_id(academic_year, at_id, cl_id, cd_id);
		
		List<Object> quarterResultList = new ArrayList<>();
		
		for(Object obj : studentQuarterResult){
			
			Object[] fields = (Object[])obj;
			
			Object[] new_fields = new Object[fields.length + 1];
			
			for(int i = 0; i < fields.length; i++){
			
				new_fields[i] = fields[i];
			}
			
			new_fields[fields.length] = Double.parseDouble(fields[5].toString())/sub_number;
			
			quarterResultList.add(new_fields);
		}
		///*** END - Generate student quarter result list ***///
		
		
		///*** Setting Objects to ExamResult values ***///
		List<ExamResult> qrtResultList = new ArrayList<>();
		
		for(Object obj : quarterResultList){
			
			Object[] feilds = (Object[])obj;
			
			ExamResult er = new ExamResult();
			
			StudentInformation si = new StudentInformation();
			si.setSi_id(Integer.parseInt(feilds[0].toString()));
			si.setFname(feilds[1].toString());
			si.setMname(feilds[2].toString());
			si.setGname(feilds[3].toString());			
			er.setStudentInformation(si);
			
			er.setAt_id(Integer.parseInt(feilds[4].toString()));
			er.setResult(Double.parseDouble(feilds[5].toString()));
			er.setAverage_result(Double.parseDouble(feilds[10].toString()));
			
			qrtResultList.add(er);
		}
		///*** END - Setting Objects to ExamResult values ***///
				
		
		///*** Sorting students based on total-result ***///
		if(quarterResultList.size() > 0){
			
			Collections.sort(qrtResultList, new Comparator<ExamResult>() {
				
				public int compare(ExamResult a, ExamResult b){
					
					if(b.getResult() == a.getResult()){
						return 0;
					} else if(b.getResult() > a.getResult()){
						return 1;
					} else {
						return -1;
					}
				}
			});
		}		
		///*** END - Sorting students based on total-result ***///
		
		
		
		///*** Adding student rank based on the total mark ***///
		double pervious_total = 0.0;
		int pervious_rank = 0, same_rank_counter = 0;
		
		for(int i = 0; i < qrtResultList.size(); i++){
			
			if(pervious_total == 0.0){
				
				pervious_total = qrtResultList.get(i).getResult();
				
				pervious_rank = 1;
				
				qrtResultList.get(i).setStud_rank(pervious_rank);
				
			} else if(pervious_total != 0.0 && qrtResultList.get(i).getResult() == pervious_total){
				
				pervious_total = qrtResultList.get(i).getResult();
				
				qrtResultList.get(i).setStud_rank(pervious_rank);
				
				same_rank_counter++;
				
			} else {
				
				pervious_total = qrtResultList.get(i).getResult();
				
				pervious_rank = pervious_rank + same_rank_counter + 1;
				
				qrtResultList.get(i).setStud_rank(pervious_rank);
				
				same_rank_counter = 0;
			}
		}
		///*** END - Adding student rank based on the total mark ***///

		return qrtResultList;
	}

	@Override
	public List<SubjectType> getSubjectNumberAddedOnTotalMarkByCl_id(int cl_id) {
		
		return examResultDao.getSubjectNumberAddedOnTotalMarkByCl_id(cl_id);
	}

	@Override
	public List<ExamResult> getEachSubjectTotalMarkListBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id, int at_id,
			int academic_year) {
		
		return examResultDao.getEachSubjectTotalMarkListBySi_idCl_idAt_idAcademic_year(si_id, cl_id, at_id, academic_year);
	}

	@Override
	public List<ExamResult> getSubjectResultPerExamDetailBySi_idAt_idAcademic_year(int si_id, int at_id,
			int academic_year, int sub_id) {
		
		return examResultDao.getSubjectResultPerExamDetailBySi_idAt_idAcademic_year(si_id, at_id, academic_year, sub_id);
	}

	@Override
	public ExamResultComment getTeacherCommentBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id, int at_id,
			int academic_year) {
		
		return examResultDao.getTeacherCommentBySi_idCl_idAt_idAcademic_year(si_id, cl_id, at_id, academic_year);
	}

	@Override
	public List<ExamResult> getStudentQuarterResultViewBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id,
			int at_id, int academic_year) {
		
		return examResultDao.getStudentQuarterResultViewBySi_idCl_idAt_idAcademic_year(si_id, cl_id, at_id, academic_year);
	}

	@Override
	public boolean getExaminationDateValidation(int examsub_id, int academic_year) {
		
		return examResultDao.getExaminationDateValidation(examsub_id, academic_year);
	}

	@Override
	public DAAttendance getStudentAbsentDayList(int si_id, int at_id, int academic_year) {
		
		return examResultDao.getStudentAbsentDayList(si_id, at_id, academic_year);
	}

	@Override
	public String getHomeroomTeacherName(int cl_id, int cd_id, int academic_year) {
		
		return examResultDao.getHomeroomTeacherName(cl_id, cd_id, academic_year);
	}

	@Override
	public List<ExamResult> getStudentTotalResultPerEachQuarter(int cl_id, int cd_id, int academic_year) {
		
		return examResultDao.getStudentTotalResultPerEachQuarter(cl_id, cd_id, academic_year);
	}

	@Override
	public List<ExamResult> getSummerizedStudCountPerMarkInserted(int at_id, int academic_year, int et_id, int cl_id,
			int cd_id) {
		
		return examResultDao.getSummerizedStudCountPerMarkInserted(at_id, academic_year, et_id, cl_id, cd_id);
	}

}
