package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.ClassScheduleDao;
import com.fidel.sms.model.ClassScheduleSubjectPeriodRelation;
import com.fidel.sms.service.ClassScheduleService;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService {

	@Autowired
	ClassScheduleDao classScheduleDao;
	
	@Override
	public List<ClassScheduleSubjectPeriodRelation> getGeneralPeriodAssignmentByAcademicYear(int academic_year) {
		
		return classScheduleDao.getGeneralPeriodAssignmentByAcademicYear(academic_year);
	}

	@Override
	public boolean saveClassPeriodAllotment(ClassScheduleSubjectPeriodRelation subjectAllotment) {
		
		return classScheduleDao.saveClassPeriodAllotment(subjectAllotment);
	}

	@Override
	public ClassScheduleSubjectPeriodRelation getClassPeriodAllotmentByCsp_id(int csp_id) {
		
		return classScheduleDao.getClassPeriodAllotmentByCsp_id(csp_id);
	}

	@Override
	public boolean updateClassPeriodAllotment(ClassScheduleSubjectPeriodRelation subjectAllotment) {
		
		return classScheduleDao.updateClassPeriodAllotment(subjectAllotment);
	}

}
