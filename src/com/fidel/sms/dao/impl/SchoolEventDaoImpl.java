package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.SchoolEventDao;
import com.fidel.sms.model.SchoolEvent;

@Repository
public class SchoolEventDaoImpl implements SchoolEventDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SchoolEventDaoImpl(){}
	
	public SchoolEventDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<SchoolEvent> getAllSchoolEvent() {

		Query query = sessionFactory.openSession().createQuery("FROM SchoolEvent");
		
		return (List<SchoolEvent>)query.list();
	}

	@Override
	public List<SchoolEvent> getSchoolEventByAcademic_year(int academic_year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveSchoolEvent(SchoolEvent schoolEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSchoolEvent(SchoolEvent schoolEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SchoolEvent getSchoolEventBySe_id(int se_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
