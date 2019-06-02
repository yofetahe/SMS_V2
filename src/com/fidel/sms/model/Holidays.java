package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="holidays")
public class Holidays {
	
	private int h_id;
	private String h_name;
	private String h_ethio_date;
	private String h_greg_date;
	private int h_fiscalyear;
	private String work_status;
	private String h_status;
	
	@Id
	@GeneratedValue
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_ethio_date() {
		return h_ethio_date;
	}
	public void setH_ethio_date(String h_ethio_date) {
		this.h_ethio_date = h_ethio_date;
	}
	public String getH_greg_date() {
		return h_greg_date;
	}
	public void setH_greg_date(String h_greg_date) {
		this.h_greg_date = h_greg_date;
	}
	public int getH_fiscalyear() {
		return h_fiscalyear;
	}
	public void setH_fiscalyear(int h_fiscalyear) {
		this.h_fiscalyear = h_fiscalyear;
	}
	public String getWork_status() {
		return work_status;
	}
	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}
	public String getH_status() {
		return h_status;
	}
	public void setH_status(String h_status) {
		this.h_status = h_status;
	}
}
