package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.SchoolInformation;

public interface SchoolInformationDao {
	
	public SchoolInformation getSchoolInformation();
	
	public byte[] getOrganizationLogoById(int sch_inf_id);

}
