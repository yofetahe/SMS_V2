package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.SpecialNeedCategoryDao;
import com.fidel.sms.model.SpecialNeedCategory;
import com.fidel.sms.model.StudentSpecialNeedRequired;

@Repository
public class SpecialNeedCategoryDaoImpl implements SpecialNeedCategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SpecialNeedCategoryDaoImpl(){}
	
	public SpecialNeedCategoryDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<SpecialNeedCategory> getSpecialNeedsCategoryList() {
		
		final String getSpecialNeedsCategoryList = "FROM SpecialNeedCategory WHERE snc_status = 'A'";
		
		Query query = sessionFactory.openSession().createQuery(getSpecialNeedsCategoryList);
		
		return (List<SpecialNeedCategory>)query.list();
	}

	@Override
	public List<StudentSpecialNeedRequired> checkStudSpecialNeedRequirment(int si_id) {
		
		final String getStudSpecialNeedRequirment = "FROM StudentSpecialNeedRequired WHERE si_id = :si_id and ssnr_status = 'A'";
		
		Query query = sessionFactory.openSession().createQuery(getStudSpecialNeedRequirment).setParameter("si_id", si_id);
		
		return (List<StudentSpecialNeedRequired>)query.list();
	}

}
