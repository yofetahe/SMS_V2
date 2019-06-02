package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="school_event")
public class SchoolEvent {

	private int se_id;
	private String se_name;
	private String se_description;
	private String se_ethio_date;
	private String se_greg_date;
	private int se_fiscalyear;
	private String se_status;
	
	@Id
	@GeneratedValue
	public int getSe_id() {
		return se_id;
	}
	public void setSe_id(int se_id) {
		this.se_id = se_id;
	}
	public String getSe_name() {
		return se_name;
	}
	public void setSe_name(String se_name) {
		this.se_name = se_name;
	}
	public String getSe_description() {
		return se_description;
	}
	public void setSe_description(String se_description) {
		this.se_description = se_description;
	}
	public String getSe_ethio_date() {
		return se_ethio_date;
	}
	public void setSe_ethio_date(String se_ethio_date) {
		this.se_ethio_date = se_ethio_date;
	}
	public String getSe_greg_date() {
		return se_greg_date;
	}
	public void setSe_greg_date(String se_greg_date) {
		this.se_greg_date = se_greg_date;
	}
	public int getSe_fiscalyear() {
		return se_fiscalyear;
	}
	public void setSe_fiscalyear(int se_fiscalyear) {
		this.se_fiscalyear = se_fiscalyear;
	}
	public String getSe_status() {
		return se_status;
	}
	public void setSe_status(String se_status) {
		this.se_status = se_status;
	}	
}
