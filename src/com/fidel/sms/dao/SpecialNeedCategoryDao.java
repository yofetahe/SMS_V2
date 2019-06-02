package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.SpecialNeedCategory;
import com.fidel.sms.model.StudentSpecialNeedRequired;

public interface SpecialNeedCategoryDao {
	
	public List<SpecialNeedCategory> getSpecialNeedsCategoryList();
	
	public List<StudentSpecialNeedRequired> checkStudSpecialNeedRequirment(int si_id);

}
