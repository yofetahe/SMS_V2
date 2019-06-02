package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.AttendanceDao;
import com.fidel.sms.model.AnnualTerms;
import com.fidel.sms.model.DAAttendanceType;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	AttendanceDao attendanceDao;

	@Override
	public List<DAAttendanceType> getActiveAttendanceTypeList() {
		
		return attendanceDao.getActiveAttendanceTypeList();
	}

	@Override
	public List<AnnualTerms> getActiveAnnualQuarters() {
		
		return attendanceDao.getActiveAnnualQuarters();
	}

	@Override
	public Integer getClassCapacity(int cl_id, int cd_id) {
		
		return attendanceDao.getClassCapacity(cl_id, cd_id);
	}

	@Override
	public List<StudentInformation> getAbsentStudentListByCl_idCD_idDate(int cl_id, int cd_id, String attendance_date) {
		
		return attendanceDao.getAbsentStudentListByCl_idCD_idDate(cl_id, cd_id, attendance_date);
	}

	@Override
	public List<StudentInformation> getAggregateStudentAbsentListByCl_idCD_idAt_id(int cl_id, int cd_id, int at_id) {
		
		return attendanceDao.getAggregateStudentAbsentListByCl_idCD_idAt_id(cl_id, cd_id, at_id);
	}

	
	
	
	
	///*** Admin - Attendance Type ***///
	@Override
	public List<DAAttendanceType> getAllAttendanceTypeList() {
		
		return attendanceDao.getAllAttendanceTypeList();
	}

}
