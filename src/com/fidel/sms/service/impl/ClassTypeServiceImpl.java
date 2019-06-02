package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.ClassTypeDao;
import com.fidel.sms.model.ClassDetail;
import com.fidel.sms.model.ClassType;
import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.service.ClassTypeService;

@Service
public class ClassTypeServiceImpl implements ClassTypeService {
	
	@Autowired
	ClassTypeDao classTypeDao;

	@Override
	public List<ClassType> getActiveClassList() {
		
		return classTypeDao.getActiveClassList();
	}	

	@Override
	public ClassType getClassTypeByCl_id(int cl_id) {
		
		return classTypeDao.getClassTypeByCl_id(cl_id);
	}

	@Override
	public List<ClassDetail> getNotFilteredClassDetailPerSelectedClass(int cl_id) {
		
		return classTypeDao.getNotFilteredClassDetailPerSelectedClass(cl_id);
	}

	@Override
	public List<ClassDetail> getFilteredClassDetailUnderSelectedClass(int cl_id, int cd_id) {
		
		return classTypeDao.getFilteredClassDetailUnderSelectedClass(cl_id, cd_id);
	}

	@Override
	public List<ClassDetail> getClassDetailListByCl_id(int cl_id) {
		
		return classTypeDao.getClassDetailListByCl_id(cl_id);
	}

	@Override
	public List<ClassType> getAllClassList() {
		
		return classTypeDao.getAllClassList();
	}

	@Override
	public List<ClassDetail> getAllClassDetail() {
		
		return classTypeDao.getAllClassDetail();
	}

	@Override
	public List<ClassDetail> getRelatedClassDetailByCl_id(int cl_id) {
		
		return classTypeDao.getRelatedClassDetailByCl_id(cl_id);
	}

	@Override
	public List<SubjectType> getRelatedSubjectByCl_id(int cl_id) {
		
		return classTypeDao.getRelatedSubjectByCl_id(cl_id);
	}

	@Override
	public List<SubjectType> getUnrelatedSubjectByCl_id(int cl_id) {
		
		return classTypeDao.getUnrelatedSubjectByCl_id(cl_id);
	}

	@Override
	public List<ExamsType> getRelatedExamTypeBySubCl_id(int subcl_id) {
		
		return classTypeDao.getRelatedExamTypeBySubCl_id(subcl_id);
	}

	@Override
	public List<ExamGrade> getRelatedExamGradingBySubCl_id(int subcl_id) {
		
		return classTypeDao.getRelatedExamGradingBySubCl_id(subcl_id);
	}

	@Override
	public ClassDetail getClassDetailByCd_id(int cd_id) {
		
		return classTypeDao.getClassDetailByCd_id(cd_id);
	}

	@Override
	public List<ClassType> getClassListOtherThanCurrentClass(int cl_id) {
		
		return classTypeDao.getClassListOtherThanCurrentClass(cl_id);
	}

}
