package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.NonAcadmicEmployeeInformation;

public interface NonAcademicDao {

	public List<NonAcadmicEmployeeInformation> getNonAcadmicStuffList();
	
	public NonAcadmicEmployeeInformation getNonAcadmicStuffInfoByNti_id(int nti_id);
}
