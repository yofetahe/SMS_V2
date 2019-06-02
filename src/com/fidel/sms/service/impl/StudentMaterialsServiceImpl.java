package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.StudentMaterialsDao;
import com.fidel.sms.model.PaymentMaterialClassRelation;
import com.fidel.sms.model.PaymentTypeMaterialList;
import com.fidel.sms.service.StudentMaterialsService;

@Service
public class StudentMaterialsServiceImpl implements StudentMaterialsService {

	@Autowired
	StudentMaterialsDao studentMaterialsDao;
	
	@Override
	public List<PaymentTypeMaterialList> getAllStudentMaterialList() {
		
		return studentMaterialsDao.getAllStudentMaterialList();
	}

	@Override
	public List<PaymentMaterialClassRelation> getAllClassMaterialRelationList() {
		
		return studentMaterialsDao.getAllClassMaterialRelationList();
	}

}
