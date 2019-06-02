package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.PaymentMaterialClassRelation;
import com.fidel.sms.model.PaymentTypeMaterialList;

public interface StudentMaterialsService {

	public List<PaymentTypeMaterialList> getAllStudentMaterialList();
	
	public List<PaymentMaterialClassRelation> getAllClassMaterialRelationList();
}
