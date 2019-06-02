package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.SpecialNeedCategory;
import com.fidel.sms.model.StudentSpecialNeedRequired;

public interface SpecialNeedCategoryService {
	
	public List<SpecialNeedCategory> getSpecialNeedsCategoryList();
	
	public List<StudentSpecialNeedRequired> checkStudSpecialNeedRequirment(int si_id);

}
