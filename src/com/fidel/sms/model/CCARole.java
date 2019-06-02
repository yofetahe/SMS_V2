package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cca_role")
public class CCARole {
	
	private int role_id;
	private String role_name;
	private String role_responsibilities;
	private String role_status;
	
	@Id
	@GeneratedValue
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_responsibilities() {
		return role_responsibilities;
	}
	public void setRole_responsibilities(String role_responsibilities) {
		this.role_responsibilities = role_responsibilities;
	}
	public String getRole_status() {
		return role_status;
	}
	public void setRole_status(String role_status) {
		this.role_status = role_status;
	}
}
