package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.SubjectExamTypeDao;
import com.fidel.sms.model.ExamGrade;
import com.fidel.sms.model.ExamsType;
import com.fidel.sms.model.SubjectType;
import com.fidel.sms.service.SubjectExamTypeService;

@Service
public class SubjectExamTypeServiceImpl implements SubjectExamTypeService {
	
	@Autowired
	SubjectExamTypeDao subjectExamTypeDao;

	@Override
	public List<SubjectType> getAllSubjectType() {
		
		return subjectExamTypeDao.getAllSubjectType();
	}

	@Override
	public List<ExamsType> getAllExamType() {
		
		return subjectExamTypeDao.getAllExamType();
	}

	@Override
	public List<ExamsType> getActiveExamType() {
		
		return subjectExamTypeDao.getActiveExamType();
	}
	
	@Override
	public List<SubjectType> getSubjectListWithPeriodAllotmentByCl_id(int cl_id) {
		
		return subjectExamTypeDao.getSubjectListWithPeriodAllotmentByCl_id(cl_id);
	}

	@Override
	public List<ExamGrade> getExamGradingList() {
		
		return subjectExamTypeDao.getExamGradingList();
	}

	@Override
	public List<SubjectType> getSubjectTypeListByCl_id(int cl_id) {
		
		return subjectExamTypeDao.getSubjectTypeListByCl_id(cl_id);
	}

	@Override
	public List<ExamsType> getScheduledExamTypesBySubCl_idAcademic_yearAt_idCl_id(int academic_year, int at_id, int cl_id, int subcl_id) {
		
		return subjectExamTypeDao.getScheduledExamTypesBySubCl_idAcademic_yearAt_idCl_id(academic_year, at_id, cl_id, subcl_id);
	}


}
