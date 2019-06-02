package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.PaymentClassRelation;
import com.fidel.sms.model.PaymentFine;
import com.fidel.sms.model.PaymentType;

public interface PaymentDao {

	///*** ADMIN - Payment Amount Registration ***///
	public List<PaymentType> getActivePaymentTypeList();

	public List<PaymentClassRelation> getPaymentAmountList();
}
