package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.PaymentMaterialClassRelation;
import com.fidel.sms.model.PaymentTypeMaterialList;

public interface StudentMaterialsDao {

	public List<PaymentTypeMaterialList> getAllStudentMaterialList();

	public List<PaymentMaterialClassRelation> getAllClassMaterialRelationList();
}
