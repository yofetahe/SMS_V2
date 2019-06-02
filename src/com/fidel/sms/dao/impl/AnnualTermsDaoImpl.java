package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.AnnualTermsDao;
import com.fidel.sms.model.AnnualTerms;

@Repository
public class AnnualTermsDaoImpl implements AnnualTermsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AnnualTermsDaoImpl(){}
	
	public AnnualTermsDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<AnnualTerms> getAllAnnualTermsList() {

		Query query = sessionFactory.openSession().createQuery("FROM AnnualTerms");
		
		return (List<AnnualTerms>)query.list();
	}

	@Override
	public List<AnnualTerms> getActiveAnnualTermsList() {

		Query query = sessionFactory.openSession().createQuery("FROM AnnualTerms WHERE at_status = 'A'");
		
		return (List<AnnualTerms>)query.list();
	}

	@Override
	public AnnualTerms getAnnualTermsByAt_id(int at_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveAnnualTerms(AnnualTerms annualTerms) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAnnualTerms(AnnualTerms annualTerms) {
		// TODO Auto-generated method stub
		return false;
	}

}
