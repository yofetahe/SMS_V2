package com.fidel.sms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.BehaviouralEvaluationDao;
import com.fidel.sms.model.BEvaluationGrade;
import com.fidel.sms.model.BEvaluationStudentResult;
import com.fidel.sms.model.BEvaluationTraits;

@Service
public class BehaviouralEvaluationService implements com.fidel.sms.service.BehaviouralEvaluationService {

	@Autowired
	BehaviouralEvaluationDao behEvalDao;
	
	@Override
	public List<BEvaluationStudentResult> getStudentEvaluationResultBySi_idCl_id(int si_id, int cl_id, int at_id, int academic_year) {
		
		return behEvalDao.getStudentEvaluationResultBySi_idCl_id(si_id, cl_id, at_id, academic_year);
	}

	@Override
	public List<Object> getBehavioralEvalTraints(int si_id, int cl_id, int at_id) {
		
		List<BEvaluationTraits> bevalTraitList = behEvalDao.getBehavioralEvalTraints(si_id, cl_id, at_id);
		System.out.println(bevalTraitList.size() + " size");
		List<Object> bevalTrait = new ArrayList<>();
		
		for(Object obj : bevalTraitList){
			
			Object[] feild = (Object[])obj;
			Object[] feild_2 = new Object[3];
			
			feild_2[0] = feild[0]; //adding et_id
			feild_2[1] = feild[1]; //adding et_title
			
			String[] bg_id = feild[2].toString().split(",");
			String[] bg_name = feild[3].toString().split(",");
			
			List<BEvaluationGrade> evalGrade = new ArrayList<>();
			
			for(int i = 0; i < bg_id.length; i++){
				
				BEvaluationGrade eg = new BEvaluationGrade();
				
				eg.setBg_id(Integer.parseInt(bg_id[i]));
				eg.setBg_name(bg_name[i]);
				
				evalGrade.add(eg);
			}
			
			///*** sorting grading values ***///
			Collections.sort(evalGrade, new Comparator<BEvaluationGrade>() {
				
				public int compare(BEvaluationGrade a, BEvaluationGrade b){
										
					return a.getBg_name().compareTo(b.getBg_name());					
				}
			});
						
			feild_2[2] = evalGrade; //adding eg_id and eg_name list
			
			bevalTrait.add(feild_2);
		}
		
		return bevalTrait;
	}

}
