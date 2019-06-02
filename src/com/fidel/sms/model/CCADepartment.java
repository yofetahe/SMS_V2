package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cca_department")
public class CCADepartment {

	private int dep_id;
	private String dep_name;
	private String dep_desc;
	private String dep_status;
	
	@Id
	@GeneratedValue
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getDep_desc() {
		return dep_desc;
	}
	public void setDep_desc(String dep_desc) {
		this.dep_desc = dep_desc;
	}
	public String getDep_status() {
		return dep_status;
	}
	public void setDep_status(String dep_status) {
		this.dep_status = dep_status;
	}
}
