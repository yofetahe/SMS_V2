package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.SpecialNeedCategoryDao;
import com.fidel.sms.model.SpecialNeedCategory;
import com.fidel.sms.model.StudentSpecialNeedRequired;
import com.fidel.sms.service.SpecialNeedCategoryService;

@Service
public class SpecialNeedCategoryServiceImpl implements SpecialNeedCategoryService {
	
	@Autowired
	SpecialNeedCategoryDao speicalNeedCategoryDao;

	@Override
	public List<SpecialNeedCategory> getSpecialNeedsCategoryList() {
		
		return speicalNeedCategoryDao.getSpecialNeedsCategoryList();
	}

	@Override
	public List<StudentSpecialNeedRequired> checkStudSpecialNeedRequirment(int si_id) {
		
		return speicalNeedCategoryDao.checkStudSpecialNeedRequirment(si_id);
	}

}
