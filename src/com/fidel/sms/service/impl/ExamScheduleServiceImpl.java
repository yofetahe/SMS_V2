package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.ExamScheduleDao;
import com.fidel.sms.model.ExamSchedule;
import com.fidel.sms.service.ExamScheduleService;

@Service
public class ExamScheduleServiceImpl implements ExamScheduleService {
	
	@Autowired
	ExamScheduleDao examScheduleDao;

	@Override
	public List<ExamSchedule> getExamScheduleByCl_idAt_idAcademic_year(int cl_id, int at_id, int academic_year) {
		
		return examScheduleDao.getExamScheduleByCl_idAt_idAcademic_year(cl_id, at_id, academic_year);
	}

}
