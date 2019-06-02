package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.Holidays;

public interface HolidaysService {

	public List<Holidays> getAllHolidays();
	
	public List<Holidays> getActiveHolidays();
	
	public Holidays getHolidayByH_id(int h_id);
	
	public boolean saveHoliday(Holidays holiday);
	
	public boolean updateHoliday(Holidays holiday);
}
