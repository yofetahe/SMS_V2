package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.TeacherDao;
import com.fidel.sms.model.TeacherAssignment;
import com.fidel.sms.model.TeacherCurrentAddress;
import com.fidel.sms.model.TeacherDisciplinaryAction;
import com.fidel.sms.model.TeacherEducationBackground;
import com.fidel.sms.model.TeacherEmergencyContact;
import com.fidel.sms.model.TeacherHomeRoomAssignment;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.model.TeacherReward;
import com.fidel.sms.model.TeacherWorkExperience;
import com.fidel.sms.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	
	@Override
	public List<TeacherInformation> getActiveTeacherList() {
		
		return teacherDao.getActiveTeacherList();
	}

	@Override
	public List<TeacherInformation> getInactiveTeacherList() {
		
		return teacherDao.getInactiveTeacherList();
	}

	@Override
	public TeacherInformation getTeacherInformationByTi_id(int ti_id) {
		
		return teacherDao.getTeacherInformationByTi_id(ti_id);
	}

	@Override
	public byte[] getTeacherPhotoByTiid(int ti_id) {
		
		return teacherDao.getTeacherPhotoByTiid(ti_id);
	}

	@Override
	public List<TeacherEducationBackground> getTeacherEducationalBackgroundByTi_id(int ti_id) {
		
		return teacherDao.getTeacherEducationalBackgroundByTi_id(ti_id);
	}

	@Override
	public List<TeacherWorkExperience> getTeacherWorkExperienceByTi_id(int ti_id) {
		
		return teacherDao.getTeacherWorkExperienceByTi_id(ti_id);
	}

	@Override
	public TeacherCurrentAddress getTeacherCurrentAddressByTi_id(int ti_id) {
		
		return teacherDao.getTeacherCurrentAddressByTi_id(ti_id);
	}

	@Override
	public TeacherEmergencyContact getTeacherEmergencyContactByTi_id(int ti_id) {
		
		return teacherDao.getTeacherEmergencyContactByTi_id(ti_id);
	}

	@Override
	public List<TeacherReward> getTeacherRewardListByTi_id(int ti_id) {
		
		return teacherDao.getTeacherRewardListByTi_id(ti_id);
	}

	@Override
	public List<TeacherDisciplinaryAction> getTeacherDisciplinaryActionByTi_id(int ti_id) {
		
		return teacherDao.getTeacherDisciplinaryActionByTi_id(ti_id);
	}

	@Override
	public List<TeacherAssignment> getTeacherClassSubjectAssignmentByTi_id(int ti_id) {
		
		return teacherDao.getTeacherClassSubjectAssignmentByTi_id(ti_id);
	}

	@Override
	public List<TeacherHomeRoomAssignment> getAssignedHomeRoomTeacherListByAcademic_year(int academic_year) {
		
		return teacherDao.getAssignedHomeRoomTeacherListByAcademic_year(academic_year);
	}

}
