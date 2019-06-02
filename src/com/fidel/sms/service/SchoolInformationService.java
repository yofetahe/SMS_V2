package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.SchoolInformation;

public interface SchoolInformationService {

	public SchoolInformation getSchoolInformation();	

	public byte[] getOrganizationLogoById(int sch_inf_id);
}
