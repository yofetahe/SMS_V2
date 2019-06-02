package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uaccount_utype_rel")
public class UserAccountUserTypeRelation {

	private int uaut_id;
	private int ua_id;
	private int ut_id;
	private String uaut_status;
	
	@Id
	@GeneratedValue
	public int getUaut_id() {
		return uaut_id;
	}
	public void setUaut_id(int uaut_id) {
		this.uaut_id = uaut_id;
	}
	public int getUa_id() {
		return ua_id;
	}
	public void setUa_id(int ua_id) {
		this.ua_id = ua_id;
	}
	public int getUt_id() {
		return ut_id;
	}
	public void setUt_id(int ut_id) {
		this.ut_id = ut_id;
	}
	public String getUaut_status() {
		return uaut_status;
	}
	public void setUaut_status(String uaut_status) {
		this.uaut_status = uaut_status;
	}
	
}
