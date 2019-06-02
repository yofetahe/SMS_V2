package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tech_assignment")
public class TeacherAssignment {

	private int ta_id;
	private int sub_id;
	private int cl_id;
	private int year;
	private String ta_status;
	private int ti_id;
	
	@Id
	@GeneratedValue
	public int getTa_id() {
		return ta_id;
	}
	public void setTa_id(int ta_id) {
		this.ta_id = ta_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTa_status() {
		return ta_status;
	}
	public void setTa_status(String ta_status) {
		this.ta_status = ta_status;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	
}
