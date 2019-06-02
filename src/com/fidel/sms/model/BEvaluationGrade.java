package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beval_grade")
public class BEvaluationGrade {
	
	private int bg_id;
	private String bg_name;
	private String bg_desc;
	private String bg_status;
	
	@Id
	@GeneratedValue
	public int getBg_id() {
		return bg_id;
	}
	public void setBg_id(int bg_id) {
		this.bg_id = bg_id;
	}
	public String getBg_name() {
		return bg_name;
	}
	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}
	public String getBg_desc() {
		return bg_desc;
	}
	public void setBg_desc(String bg_desc) {
		this.bg_desc = bg_desc;
	}
	public String getBg_status() {
		return bg_status;
	}
	public void setBg_status(String bg_status) {
		this.bg_status = bg_status;
	}
}
