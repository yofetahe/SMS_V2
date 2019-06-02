package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.SchoolEvent;

public interface SchoolEventDao {

	public List<SchoolEvent> getAllSchoolEvent();
	
	public List<SchoolEvent> getSchoolEventByAcademic_year(int academic_year);
	
	public boolean saveSchoolEvent(SchoolEvent schoolEvent);
	
	public boolean updateSchoolEvent(SchoolEvent schoolEvent);
	
	public SchoolEvent getSchoolEventBySe_id(int se_id);
}
