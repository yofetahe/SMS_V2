package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.StudentDao;
import com.fidel.sms.model.StudentCurrentAddress;
import com.fidel.sms.model.StudentDisciplinaryAction;
import com.fidel.sms.model.StudentEmergencyContact;
import com.fidel.sms.model.StudentInformation;
import com.fidel.sms.model.StudentRegistration;
import com.fidel.sms.model.StudentReward;
import com.fidel.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public List<StudentInformation> stud_db_persex() {
		
		return studentDao.stud_db_persex();
	}

	@Override
	public List<StudentInformation> getStudentNumPerClass(int academic_year) {
		
		return studentDao.getStudentNumPerClass(academic_year);
	}

	@Override
	public List<StudentInformation> getStudentCountPerGradeDetail(StudentRegistration studInfo) {
		
		return studentDao.getStudentCountPerGradeDetail(studInfo);
	}

	@Override
	public List<StudentInformation> getStudentListPerGradeDetail(int cl_id, int cd_id, int academic_year) {
		
		return studentDao.getStudentListPerGradeDetail(cl_id, cd_id, academic_year);
	}

	@Override
	public List<StudentInformation> getStudentsListPerGrade(int cl_id, int academic_year) {
		
		return studentDao.getStudentsListPerGrade(cl_id, academic_year);
	}

	@Override
	public StudentInformation getStudentInformationById(int si_id) {
		
		return studentDao.getStudentInformationById(si_id);
	}

	@Override
	public byte[] getStudentPhotoBySiid(int si_id) {
		
		return studentDao.getStudentPhotoBySiid(si_id);
	}

	@Override
	public List<StudentEmergencyContact> getStudentContactInformationListPerGradeDetail(int cl_id, int cd_id,
			int academic_year) {
		
		return studentDao.getStudentContactInformationListPerGradeDetail(cl_id, cd_id, academic_year);
	}

	@Override
	public List<StudentInformation> getAllStudentInformationPerSelectedAcademicYear(int academic_year) {
		
		return studentDao.getAllStudentInformationPerSelectedAcademicYear(academic_year);
	}
	
	@Override
	public List<StudentInformation> getAllInactiveStudentInformationPerSelectedAcademicYear(int academic_year) {
		
		return studentDao.getAllInactiveStudentInformationPerSelectedAcademicYear(academic_year);
	}

	@Override
	public List<StudentInformation> getAllNewCandidateStudentInformation() {
		
		return studentDao.getAllNewCandidateStudentInformation();
	}
	
	
	
	
	///*** STUDENT REGISTRATION ***///
	
	@Override
	public List<StudentInformation> getStudentsListForRegistration(int cl_id, int academic_year) {
		
		return studentDao.getStudentsListForRegistration(cl_id, academic_year);
	}

	
	
	
	///*** CURRENT ADDRESS ***///
	
	@Override
	public List<StudentCurrentAddress> getStudentCurrentAddressBySiid(int si_id) {
		
		return studentDao.getStudentCurrentAddressBySiid(si_id);
	}

	///*** END - CURRENT ADDRESS ***///
	
	
	
	
	///*** EMERGENCY CONTACT ***///
	
	@Override
	public List<StudentEmergencyContact> getStudentEmergencyContactBySiid(int si_id) {
		
		return studentDao.getStudentEmergencyContactBySiid(si_id);
	}

	@Override
	public StudentEmergencyContact getStudentEmergencyContactBySecid(int sec_id) {
		
		return studentDao.getStudentEmergencyContactBySecid(sec_id);
	}

	///*** END - EMERGENCY CONTACT ***///
	
	
	
	///*** STUDENT REWARD ***///
	
	@Override
	public List<StudentReward> getStudentRewardListBySiid(int si_id) {
		
		return studentDao.getStudentRewardListBySiid(si_id);
	}

	@Override
	public StudentReward getStudentRewardBySrid(int sr_id) {
		
		return studentDao.getStudentRewardBySrid(sr_id);
	}

	///*** END - STUDENT REWARD ***///
	
	
	
	
	///*** STUDENT DISCIPLINARY ACTION ***///

	@Override
	public List<StudentDisciplinaryAction> getStudentDisciplinaryActionListBySiid(int si_id) {
		
		return studentDao.getStudentDisciplinaryActionListBySiid(si_id);
	}

	@Override
	public StudentDisciplinaryAction getStudentDisciplinaryActionBySdaid(int sda_id) {
		
		return studentDao.getStudentDisciplinaryActionBySdaid(sda_id);
	}

	///*** END - STUDENT DISCIPLINARY ACTION ***///
	
	
	
	///*** ADMIN - ID CARD GENERATION ***///
	
	@Override
	public List<StudentInformation> getStudListWithIDPerGradeDetail(int cl_id, int cd_id, int academic_year) {
		
		return studentDao.getStudListWithIDPerGradeDetail(cl_id, cd_id, academic_year);
	}

	@Override
	public List<StudentInformation> getStudListWithoutIDPerGradeDetail(int cl_id, int cd_id, int academic_year) {
		
		return studentDao.getStudListWithoutIDPerGradeDetail(cl_id, cd_id, academic_year);
	}

	@Override
	public List<StudentInformation> getStudentListWithoutPhotoByCl_idCd_idAcadmic_year(int cl_id, int cd_id,
			int academic_year) {
		
		return studentDao.getStudentListWithoutPhotoByCl_idCd_idAcadmic_year(cl_id, cd_id, academic_year);
	}

	@Override
	public List<StudentInformation> getStudentWithoutContactInfoByCl_idCd_idAcadmic_year(int cl_id, int cd_id,
			int academic_year) {
		
		return studentDao.getStudentWithoutContactInfoByCl_idCd_idAcadmic_year(cl_id, cd_id, academic_year);
	}
	
	///*** END - ADMIN - ID CARD GENERATION ***///
	
	
	

	///*** ADMIN - Special Registration ***///
	
	@Override
	public List<StudentInformation> getUnregistedStudentListPerGradeDetailForSpecialReg(int cl_id, int cd_id,
			int academic_year) {
		
		return studentDao.getUnregistedStudentListPerGradeDetailForSpecialReg(cl_id, cd_id, academic_year);
	}

	@Override
	public List<StudentInformation> getRegisteredStudentListPerGradeDetailForSpecialReg(int cl_id, int cd_id,
			int academic_year) {
		
		return studentDao.getRegisteredStudentListPerGradeDetailForSpecialReg(cl_id, cd_id, academic_year);
	}

	///*** END - ADMIN - Special Registration ***///
	

	@Override
	public int getStudentNumberPerClassDetail(int cl_id, int cd_id, int academic_year) {
		
		return studentDao.getStudentNumberPerClassDetail(cl_id, cd_id, academic_year);
	}

	@Override
	public List<StudentInformation> searchStudentByCl_idCd_idName(int cl_id, int cd_id, String searchName) {
		
		return studentDao.searchStudentByCl_idCd_idName(cl_id, cd_id, searchName);
	}
	
}
