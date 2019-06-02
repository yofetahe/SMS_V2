package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.SchoolEvent;

public interface SchoolEventService {


	public List<SchoolEvent> getAllSchoolEvent();
	
	public List<SchoolEvent> getSchoolEventByAcademic_year(int academic_year);
	
	public boolean saveSchoolEvent(SchoolEvent schoolEvent);
	
	public boolean updateSchoolEvent(SchoolEvent schoolEvent);
	
	public SchoolEvent getSchoolEventBySe_id(int se_id);
}
