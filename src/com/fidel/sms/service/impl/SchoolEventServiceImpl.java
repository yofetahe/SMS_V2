package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.SchoolEventDao;
import com.fidel.sms.model.SchoolEvent;
import com.fidel.sms.service.SchoolEventService;

@Service
public class SchoolEventServiceImpl implements SchoolEventService {

	@Autowired
	SchoolEventDao schoolEventDao;
	
	@Override
	public List<SchoolEvent> getAllSchoolEvent() {
		
		return schoolEventDao.getAllSchoolEvent();
	}

	@Override
	public List<SchoolEvent> getSchoolEventByAcademic_year(int academic_year) {
		
		return schoolEventDao.getSchoolEventByAcademic_year(academic_year);
	}

	@Override
	public boolean saveSchoolEvent(SchoolEvent schoolEvent) {
		
		return schoolEventDao.saveSchoolEvent(schoolEvent);
	}

	@Override
	public boolean updateSchoolEvent(SchoolEvent schoolEvent) {
		
		return schoolEventDao.updateSchoolEvent(schoolEvent);
	}

	@Override
	public SchoolEvent getSchoolEventBySe_id(int se_id) {
		
		return schoolEventDao.getSchoolEventBySe_id(se_id);
	}

}
