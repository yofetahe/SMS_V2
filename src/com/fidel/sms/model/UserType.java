package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_type")
public class UserType {
	
	private int ut_id;
    private String ut_name;
    private String related_with;
    private String ut_status;
    
    @Id
	@GeneratedValue
	public int getUt_id() {
		return ut_id;
	}
	public void setUt_id(int ut_id) {
		this.ut_id = ut_id;
	}
	public String getUt_name() {
		return ut_name;
	}
	public void setUt_name(String ut_name) {
		this.ut_name = ut_name;
	}
	public String getRelated_with() {
		return related_with;
	}
	public void setRelated_with(String related_with) {
		this.related_with = related_with;
	}
	public String getUt_status() {
		return ut_status;
	}
	public void setUt_status(String ut_status) {
		this.ut_status = ut_status;
	}
    
}
