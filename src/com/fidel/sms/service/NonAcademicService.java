package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.NonAcadmicEmployeeInformation;

public interface NonAcademicService {

	public List<NonAcadmicEmployeeInformation> getNonAcadmicStuffList();
	
	public NonAcadmicEmployeeInformation getNonAcadmicStuffInfoByNti_id(int nti_id);
}
