package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tech_displinary_action")
public class TeacherDisciplinaryAction {

	private int tda_id;
	private String tda_type;
	private String tda_reason;
	private Date tda_date;
	private String tda_status;
	private int ti_id;
	
	@Id
	@GeneratedValue
	public int getTda_id() {
		return tda_id;
	}
	public void setTda_id(int tda_id) {
		this.tda_id = tda_id;
	}
	public String getTda_type() {
		return tda_type;
	}
	public void setTda_type(String tda_type) {
		this.tda_type = tda_type;
	}
	public String getTda_reason() {
		return tda_reason;
	}
	public void setTda_reason(String tda_reason) {
		this.tda_reason = tda_reason;
	}
	public Date getTda_date() {
		return tda_date;
	}
	public void setTda_date(Date tda_date) {
		this.tda_date = tda_date;
	}
	public String getTda_status() {
		return tda_status;
	}
	public void setTda_status(String tda_status) {
		this.tda_status = tda_status;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	
}
