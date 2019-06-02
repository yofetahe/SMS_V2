package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.BEvaluationStudentResult;
import com.fidel.sms.model.BEvaluationTraits;

public interface BehaviouralEvaluationDao {

	public List<BEvaluationStudentResult> getStudentEvaluationResultBySi_idCl_id(int si_id, int cl_id, int at_id, int academic_year);
	
	public List<BEvaluationTraits> getBehavioralEvalTraints(int si_id, int cl_id, int at_id);
}
