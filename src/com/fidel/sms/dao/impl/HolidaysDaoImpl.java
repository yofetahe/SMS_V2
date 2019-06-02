package com.fidel.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.HolidaysDao;
import com.fidel.sms.model.Holidays;

@Repository
public class HolidaysDaoImpl implements HolidaysDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public HolidaysDaoImpl(){}
	
	public HolidaysDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Holidays> getAllHolidays() {
		
		Query query = sessionFactory.openSession().createQuery("FROM Holidays");
		
		return (List<Holidays>)query.list();
	}

	@Override
	public List<Holidays> getActiveHolidays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Holidays getHolidayByH_id(int h_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveHoliday(Holidays holiday) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHoliday(Holidays holiday) {
		// TODO Auto-generated method stub
		return false;
	}

}
