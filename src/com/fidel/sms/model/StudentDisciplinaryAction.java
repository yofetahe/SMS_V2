package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud_disciplinary_action")
public class StudentDisciplinaryAction {

	private int sda_id;
	private String sda_type;
	private String sda_reason;
	private Date sda_date;
	private String sda_status;
	private int si_id;
	
	@Id
	@GeneratedValue
	public int getSda_id() {
		return sda_id;
	}
	public void setSda_id(int sda_id) {
		this.sda_id = sda_id;
	}
	public String getSda_type() {
		return sda_type;
	}
	public void setSda_type(String sda_type) {
		this.sda_type = sda_type;
	}
	public String getSda_reason() {
		return sda_reason;
	}
	public void setSda_reason(String sda_reason) {
		this.sda_reason = sda_reason;
	}
	public Date getSda_date() {
		return sda_date;
	}
	public void setSda_date(Date sda_date) {
		this.sda_date = sda_date;
	}
	public String getSda_status() {
		return sda_status;
	}
	public void setSda_status(String sda_status) {
		this.sda_status = sda_status;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	
}
