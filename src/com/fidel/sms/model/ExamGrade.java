package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam_grade")
public class ExamGrade {
	
	private int eg_id;
	private String eg_value;
	private String eg_desc;
	private String eg_status;
	
	@Id
	@GeneratedValue
	public int getEg_id() {
		return eg_id;
	}
	public void setEg_id(int eg_id) {
		this.eg_id = eg_id;
	}
	public String getEg_value() {
		return eg_value;
	}
	public void setEg_value(String eg_value) {
		this.eg_value = eg_value;
	}
	public String getEg_desc() {
		return eg_desc;
	}
	public void setEg_desc(String eg_desc) {
		this.eg_desc = eg_desc;
	}
	public String getEg_status() {
		return eg_status;
	}
	public void setEg_status(String eg_status) {
		this.eg_status = eg_status;
	}	
}
