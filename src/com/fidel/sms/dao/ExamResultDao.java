package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.DAAttendance;
import com.fidel.sms.model.ExamResult;
import com.fidel.sms.model.ExamResultComment;
import com.fidel.sms.model.SubjectType;

public interface ExamResultDao {


	public List<ExamResult> getUnfilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(int cl_id, int cd_id, int exsub_id, int at_id, int academic_year);

	public List<ExamResult> getFilledStudentMarkListByCl_idCd_idExsub_idAt_idAcademic_year(int cl_id, int cd_id, int exsub_id, int at_id, int academic_year);
	
	public List<ExamResult> getStudentExamResultWithStudInfoByEr_id(int er_id);
	
	public List<SubjectType> getSubjectNumberAddedOnTotalMarkByCl_id(int cl_id);
	
	public List<ExamResult> getStudentsQuarterTotalResultByAcademic_yearAt_idCl_idCd_id(int academic_year, int at_id, int cl_id, int cd_id);
	
	public List<ExamResult> getEachSubjectTotalMarkListBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id, int at_id, int academic_year);
	
	public List<ExamResult> getSubjectResultPerExamDetailBySi_idAt_idAcademic_year(int si_id, int at_id, int academic_year, int sub_id);
	
	public ExamResultComment getTeacherCommentBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id, int at_id, int academic_year);
	
	public List<ExamResult> getStudentQuarterResultViewBySi_idCl_idAt_idAcademic_year(int si_id, int cl_id, int at_id, int academic_year);
	
	public boolean getExaminationDateValidation(int examsub_id, int academic_year);
	
	public DAAttendance getStudentAbsentDayList(int si_id, int at_id, int academic_year);

	public String getHomeroomTeacherName(int cl_id, int cd_id, int academic_year);
	
	public List<ExamResult> getStudentTotalResultPerEachQuarter(int cl_id, int cd_id, int academic_year);
	
	public List<ExamResult> getSummerizedStudCountPerMarkInserted(int at_id, int academic_year, int et_id, int cl_id, int cd_id);
}
