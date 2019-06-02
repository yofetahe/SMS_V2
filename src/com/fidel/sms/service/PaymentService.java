package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.PaymentClassRelation;
import com.fidel.sms.model.PaymentFine;
import com.fidel.sms.model.PaymentType;

public interface PaymentService {

	///*** ADMIN - Payment Amount Registration ***///
	public List<PaymentType> getActivePaymentTypeList();
	
	public List<PaymentClassRelation> getPaymentAmountList();
}
