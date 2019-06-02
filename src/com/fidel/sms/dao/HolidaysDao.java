package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.Holidays;

public interface HolidaysDao {

	public List<Holidays> getAllHolidays();
	
	public List<Holidays> getActiveHolidays();
	
	public Holidays getHolidayByH_id(int h_id);
	
	public boolean saveHoliday(Holidays holiday);
	
	public boolean updateHoliday(Holidays holiday);
}
