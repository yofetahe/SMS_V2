package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectType;

public interface ClassTypeDao {

	
	public List<ClassType> getActiveClassList();

	public List<ClassType> getAllClassList();
	
	public ClassType getClassTypeByCl_id(int cl_id);

	public List<ClassDetail> getAllClassDetail();

	public List<SubjectType> getRelatedSubjectByCl_id(int cl_id);
	
	public List<SubjectType> getUnrelatedSubjectByCl_id(int cl_id);

	public List<ExamsType> getRelatedExamTypeBySubCl_id(int subcl_id);

	public List<ExamGrade> getRelatedExamGradingBySubCl_id(int subcl_id);
	
	public List<ClassType> getClassListOtherThanCurrentClass(int cl_id);
	
	
	
	
	
	
	public List<ClassDetail> getRelatedClassDetailByCl_id(int cl_id);
	
	public List<ClassDetail> getNotFilteredClassDetailPerSelectedClass(int cl_id);
	
	public List<ClassDetail> getFilteredClassDetailUnderSelectedClass(int cl_id, int cd_id);
	
	public List<ClassDetail> getClassDetailListByCl_id(int cl_id);

	public ClassDetail getClassDetailByCd_id(int cd_id);
}
