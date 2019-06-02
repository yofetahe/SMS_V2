package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cca_club")
public class CCAClub {
	
	private int clb_id;
	private String clb_name;
	private String clb_desc;
	private int dep_id;
	private String clb_status;
	
	@Id
	@GeneratedValue
	public int getClb_id() {
		return clb_id;
	}
	public void setClb_id(int clb_id) {
		this.clb_id = clb_id;
	}
	public String getClb_name() {
		return clb_name;
	}
	public void setClb_name(String clb_name) {
		this.clb_name = clb_name;
	}
	public String getClb_desc() {
		return clb_desc;
	}
	public void setClb_desc(String clb_desc) {
		this.clb_desc = clb_desc;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getClb_status() {
		return clb_status;
	}
	public void setClb_status(String clb_status) {
		this.clb_status = clb_status;
	}
}
