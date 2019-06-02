package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exams_type")
public class ExamsType {
	
	private int et_id;
	private String et_name;
	private String et_status;
	
	@Id
	@GeneratedValue
	public int getEt_id() {
		return et_id;
	}
	public void setEt_id(int et_id) {
		this.et_id = et_id;
	}
	public String getEt_name() {
		return et_name;
	}
	public void setEt_name(String et_name) {
		this.et_name = et_name;
	}
	public String getEt_status() {
		return et_status;
	}
	public void setEt_status(String et_status) {
		this.et_status = et_status;
	}
}
