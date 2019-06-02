package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidel.sms.dao.NonAcademicDao;
import com.fidel.sms.model.NonAcadmicEmployeeInformation;
import com.fidel.sms.service.NonAcademicService;

@Repository
public class NonAcademicServiceImpl implements NonAcademicService {
	
	@Autowired
	NonAcademicDao nonAcademicDao;
	
	@Override
	public List<NonAcadmicEmployeeInformation> getNonAcadmicStuffList() {
		
		return nonAcademicDao.getNonAcadmicStuffList();
	}

	@Override
	public NonAcadmicEmployeeInformation getNonAcadmicStuffInfoByNti_id(int nti_id) {
		
		return nonAcademicDao.getNonAcadmicStuffInfoByNti_id(nti_id);
	}


}
