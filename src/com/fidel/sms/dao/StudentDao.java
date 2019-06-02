package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.StudentCurrentAddress;
import com.fidel.sms.model.StudentDisciplinaryAction;
import com.fidel.sms.model.StudentEmergencyContact;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.StudentRegistration;
import com.fidel.sms.model.StudentReward;

public interface StudentDao {

	public StudentInformation getStudentInformationById(int si_id);
	
	public List<StudentInformation> stud_db_persex();
	
	public List<StudentInformation> getStudentNumPerClass(int academic_year);
	
	public List<StudentInformation> getStudentCountPerGradeDetail(StudentRegistration studInfo);
	
	public List<StudentInformation> getStudentListPerGradeDetail(int cl_id, int cd_id, int academic_year);
	
	public List<StudentInformation> getStudentsListPerGrade(int cl_id, int academic_year);
	
	public byte[] getStudentPhotoBySiid(int si_id);
	
	public List<StudentEmergencyContact> getStudentContactInformationListPerGradeDetail(int cl_id, int cd_id, int acadamic_year);

	public List<StudentInformation> getAllStudentInformationPerSelectedAcademicYear(int academic_year);
	
	public List<StudentInformation> getAllInactiveStudentInformationPerSelectedAcademicYear(int academic_year);
	
	public List<StudentInformation> getAllNewCandidateStudentInformation();
	
	public List<StudentInformation> searchStudentByCl_idCd_idName(int cl_id, int cd_id, String searchName);
	
	
	
	
	///*** STUDENT REGISTRATION ***///
	
	public List<StudentInformation> getStudentsListForRegistration(int cl_id, int academic_year);
	
	
	
	
	///*** CURRENT ADDRESS ***///
	
	public List<StudentCurrentAddress> getStudentCurrentAddressBySiid(int si_id);
	
	
	
	///*** EMERGENCY CONTACT ***///
	
	public List<StudentEmergencyContact> getStudentEmergencyContactBySiid(int si_id);
	
	public StudentEmergencyContact getStudentEmergencyContactBySecid(int sec_id);

	
	
	///*** STUDENT REWARD ***///
	
	public List<StudentReward> getStudentRewardListBySiid(int si_id);
	
	public StudentReward getStudentRewardBySrid(int sr_id);

	
	
	///*** STUDENT DISCIPLINARY ACTION ***///
	
	public List<StudentDisciplinaryAction> getStudentDisciplinaryActionListBySiid(int si_id);
	
	public StudentDisciplinaryAction getStudentDisciplinaryActionBySdaid(int sda_id);
	
	
	
	
	
	///*** ADMIN - ID Card Generation ***///
	
	public List<StudentInformation> getStudListWithIDPerGradeDetail(int cl_id, int cd_id, int academic_year);
	
	public List<StudentInformation> getStudListWithoutIDPerGradeDetail(int cl_id, int cd_id, int academic_year);

	public List<StudentInformation> getStudentListWithoutPhotoByCl_idCd_idAcadmic_year(int cl_id, int cd_id, int academic_year);

	public List<StudentInformation> getStudentWithoutContactInfoByCl_idCd_idAcadmic_year(int cl_id, int cd_id, int academic_year);
	

	
	
	
	///*** ADMIN - Special Registration ***///
	
	public List<StudentInformation> getUnregistedStudentListPerGradeDetailForSpecialReg(int cl_id, int cd_id, int academic_year);
	
	public List<StudentInformation> getRegisteredStudentListPerGradeDetailForSpecialReg(int cl_id, int cd_id, int academic_year);
	
	
	
	///*** EXAM RESULT - Quarter Certificate ***///
	
	public int getStudentNumberPerClassDetail(int cl_id, int cd_id, int academic_year);
}
