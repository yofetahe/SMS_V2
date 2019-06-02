package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.ClassScheduleSubjectPeriodRelation;

public interface ClassScheduleDao {

	///*** Admin - Class-Subject Allotment ***///
	public List<ClassScheduleSubjectPeriodRelation> getGeneralPeriodAssignmentByAcademicYear(int academic_year);
	
	public boolean saveClassPeriodAllotment(ClassScheduleSubjectPeriodRelation subjectAllotment);
	
	public ClassScheduleSubjectPeriodRelation getClassPeriodAllotmentByCsp_id(int csp_id);
	
	public boolean updateClassPeriodAllotment(ClassScheduleSubjectPeriodRelation subjectAllotment);
}
