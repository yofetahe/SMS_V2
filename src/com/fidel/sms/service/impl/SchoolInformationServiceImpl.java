package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.SchoolInformationDao;
import com.fidel.sms.model.SchoolInformation;
import com.fidel.sms.service.SchoolInformationService;

@Service
public class SchoolInformationServiceImpl implements SchoolInformationService {
	
	@Autowired
	SchoolInformationDao schoolInformationDao;

	@Override
	public SchoolInformation getSchoolInformation() {
		
		return schoolInformationDao.getSchoolInformation();
	}

	@Override
	public byte[] getOrganizationLogoById(int sch_inf_id) {
		
		return schoolInformationDao.getOrganizationLogoById(sch_inf_id);
	}

}
