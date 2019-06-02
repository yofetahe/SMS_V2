package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class_list")
public class ClassType {

	private int cl_id;
	private String class_name;
	private String class_status;
	
	@Id
	@GeneratedValue
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_status() {
		return class_status;
	}
	public void setClass_status(String class_status) {
		this.class_status = class_status;
	}
}
