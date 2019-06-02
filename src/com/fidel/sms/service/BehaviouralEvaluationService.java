package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.BEvaluationStudentResult;
import com.fidel.sms.model.BEvaluationTraits;

public interface BehaviouralEvaluationService {

	public List<BEvaluationStudentResult> getStudentEvaluationResultBySi_idCl_id(int si_id, int cl_id, int at_id, int academic_year);
	
	public List<Object> getBehavioralEvalTraints(int si_id, int cl_id, int at_id);
	
	
}
