package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_materials")
public class StudentMaterials {

	private int sm_id;
	private String sm_name;
	private String sm_desc;
	private String sm_status;
	
	@Id
	@GeneratedValue
	public int getSm_id() {
		return sm_id;
	}
	public void setSm_id(int sm_id) {
		this.sm_id = sm_id;
	}
	public String getSm_name() {
		return sm_name;
	}
	public void setSm_name(String sm_name) {
		this.sm_name = sm_name;
	}
	public String getSm_desc() {
		return sm_desc;
	}
	public void setSm_desc(String sm_desc) {
		this.sm_desc = sm_desc;
	}
	public String getSm_status() {
		return sm_status;
	}
	public void setSm_status(String sm_status) {
		this.sm_status = sm_status;
	}
	
}
