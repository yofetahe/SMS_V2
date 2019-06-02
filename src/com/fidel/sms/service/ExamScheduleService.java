package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.ExamSchedule;

public interface ExamScheduleService {
	
	public List<ExamSchedule> getExamScheduleByCl_idAt_idAcademic_year(int cl_id, int at_id, int academic_year);

}
