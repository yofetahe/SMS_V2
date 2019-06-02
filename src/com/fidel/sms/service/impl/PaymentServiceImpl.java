package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.PaymentDao;
import com.fidel.sms.model.PaymentClassRelation;
import com.fidel.sms.model.PaymentFine;
import com.fidel.sms.model.PaymentType;
import com.fidel.sms.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;
	
	@Override
	public List<PaymentType> getActivePaymentTypeList() {
		
		return paymentDao.getActivePaymentTypeList();
	}

	@Override
	public List<PaymentClassRelation> getPaymentAmountList() {
		
		return paymentDao.getPaymentAmountList();
	}

}
