package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.TeacherAssignment;
import com.fidel.sms.model.TeacherCurrentAddress;
import com.fidel.sms.model.TeacherDisciplinaryAction;
import com.fidel.sms.model.TeacherEducationBackground;
import com.fidel.sms.model.TeacherEmergencyContact;
import com.fidel.sms.model.TeacherHomeRoomAssignment;
import com.fidel.sms.model.TeacherInformation;
import com.fidel.sms.model.TeacherReward;
import com.fidel.sms.model.TeacherWorkExperience;

public interface TeacherDao {

	public List<TeacherInformation> getActiveTeacherList();
	
	public List<TeacherInformation> getInactiveTeacherList();
	
	public TeacherInformation getTeacherInformationByTi_id(int ti_id);
	
	public byte[] getTeacherPhotoByTiid(int ti_id);
	
	
	
	
	public List<TeacherEducationBackground> getTeacherEducationalBackgroundByTi_id(int ti_id);
	
	
	
	
	public List<TeacherWorkExperience> getTeacherWorkExperienceByTi_id(int ti_id);
	
	
	
	
	public TeacherCurrentAddress getTeacherCurrentAddressByTi_id(int ti_id);

	
	
	
	
	public TeacherEmergencyContact getTeacherEmergencyContactByTi_id(int ti_id);
	
	
	
	
	
	public List<TeacherReward> getTeacherRewardListByTi_id(int ti_id);
	
	
	
	
	
	List<TeacherDisciplinaryAction> getTeacherDisciplinaryActionByTi_id(int ti_id);
	
	
	
	
	
	
	List<TeacherAssignment> getTeacherClassSubjectAssignmentByTi_id(int ti_id);
	
	
	
	List<TeacherHomeRoomAssignment> getAssignedHomeRoomTeacherListByAcademic_year(int academic_year);
}
