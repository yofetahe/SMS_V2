package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.PaymentDao;
import com.fidel.sms.model.PaymentClassRelation;
import com.fidel.sms.model.PaymentFine;
import com.fidel.sms.model.PaymentType;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PaymentDaoImpl(){}
	
	public PaymentDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<PaymentType> getActivePaymentTypeList() {

		Query query = sessionFactory.openSession().createQuery("FROM PaymentType WHERE pt_status = 'A'");
		
		return (List<PaymentType>)query.list();
	}

	@Override
	public List<PaymentClassRelation> getPaymentAmountList() {

		final String hql = "SELECT a.pc_id, a.cl_id, c.class_name, a.pt_id, b.pt_name, a.pay_amount, a.penality_max_date, a.penality_percent, a.academic_year, a.pc_status "
				+ "FROM payment_class_rel a, payment_type b, class_list c "
				+ "WHERE a.pt_id = b.pt_id and a.cl_id = c.cl_id "
				+ "ORDER BY cl_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql);
		
		return (List<PaymentClassRelation>)query.list();
	}

}
