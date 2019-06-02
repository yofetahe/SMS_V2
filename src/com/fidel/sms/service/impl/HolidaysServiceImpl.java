package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.HolidaysDao;
import com.fidel.sms.model.Holidays;
import com.fidel.sms.service.HolidaysService;

@Service
public class HolidaysServiceImpl implements HolidaysService {
	
	@Autowired
	HolidaysDao holidaysDao;

	@Override
	public List<Holidays> getAllHolidays() {
		
		return holidaysDao.getAllHolidays();
	}

	@Override
	public List<Holidays> getActiveHolidays() {
		
		return holidaysDao.getActiveHolidays();
	}

	@Override
	public Holidays getHolidayByH_id(int h_id) {
		
		return holidaysDao.getHolidayByH_id(h_id);
	}

	@Override
	public boolean saveHoliday(Holidays holiday) {
		
		return holidaysDao.saveHoliday(holiday);
	}

	@Override
	public boolean updateHoliday(Holidays holiday) {
		
		return holidaysDao.updateHoliday(holiday);
	}

}
