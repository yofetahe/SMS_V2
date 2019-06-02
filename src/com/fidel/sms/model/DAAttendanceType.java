package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="da_attendance_type")
public class DAAttendanceType {

	private int attype_id;
	private String attype_description;
	private String attype_code;
	private String attype_status;
	
	@Id
	@GeneratedValue
	public int getAttype_id() {
		return attype_id;
	}
	public void setAttype_id(int attype_id) {
		this.attype_id = attype_id;
	}
	public String getAttype_description() {
		return attype_description;
	}
	public void setAttype_description(String attype_description) {
		this.attype_description = attype_description;
	}
	public String getAttype_code() {
		return attype_code;
	}
	public void setAttype_code(String attype_code) {
		this.attype_code = attype_code;
	}
	public String getAttype_status() {
		return attype_status;
	}
	public void setAttype_status(String attype_status) {
		this.attype_status = attype_status;
	}	
}
