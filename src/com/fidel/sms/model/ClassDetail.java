package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class_detail")
public class ClassDetail {

	private int cd_id;
	private String cd_name;
	private String cd_status;
	
	@Id
	@GeneratedValue
	public int getCd_id() {
		return cd_id;
	}
	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}
	public String getCd_name() {
		return cd_name;
	}
	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}
	public String getCd_status() {
		return cd_status;
	}
	public void setCd_status(String cd_status) {
		this.cd_status = cd_status;
	}	
}
