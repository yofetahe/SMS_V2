package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectType;

public interface SubjectExamTypeDao {
	
	public List<SubjectType> getAllSubjectType();
	
	public List<SubjectType> getSubjectTypeListByCl_id(int cl_id);
	
	

	///*** Exam Result ***///
	
	public List<ExamsType> getScheduledExamTypesBySubCl_idAcademic_yearAt_idCl_id(int academic_year, int at_id, int cl_id, int subcl_id);
	
	///*** END - Exam Result ***///
		
	
		
	///*** Admin - Exam type registration ***///
	public List<ExamsType> getAllExamType();

	public List<ExamsType> getActiveExamType();
	
	
	///*** Admin - Period Allotment ***///
	public List<SubjectType> getSubjectListWithPeriodAllotmentByCl_id(int cl_id);

	
	
	///*** Admin - Exam Grading ***///
	public List<ExamGrade> getExamGradingList();
}
