package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.AnnualTerms;
import com.fidel.sms.model.DAAttendanceType;
import com.fidel.sms.model.StudentInformation;

public interface AttendanceService {
	
	public List<DAAttendanceType> getActiveAttendanceTypeList();
	
	public List<AnnualTerms> getActiveAnnualQuarters();
	
	public Integer getClassCapacity(int cl_id, int cd_id);
	
	public List<StudentInformation> getAbsentStudentListByCl_idCD_idDate(int cl_id, int cd_id, String attendance_date);

	public List<StudentInformation> getAggregateStudentAbsentListByCl_idCD_idAt_id(int cl_id, int cd_id, int at_id);
	
	
	
	///*** Admin - Attendance Type Service ***///
	public List<DAAttendanceType> getAllAttendanceTypeList();
}
