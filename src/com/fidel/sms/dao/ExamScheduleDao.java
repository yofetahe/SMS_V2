package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.ExamSchedule;

public interface ExamScheduleDao {

	public List<ExamSchedule> getExamScheduleByCl_idAt_idAcademic_year(int cl_id, int at_id, int academic_year);

}
