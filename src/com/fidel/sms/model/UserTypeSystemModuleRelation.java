package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utype_module_rel")
public class UserTypeSystemModuleRelation {

	private int utm_id;
	private int ut_id;
	private int m_id;
	private String rel_status;
	
	@Id
	@GeneratedValue
	public int getUtm_id() {
		return utm_id;
	}
	public void setUtm_id(int utm_id) {
		this.utm_id = utm_id;
	}
	public int getUt_id() {
		return ut_id;
	}
	public void setUt_id(int ut_id) {
		this.ut_id = ut_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getRel_status() {
		return rel_status;
	}
	public void setRel_status(String rel_status) {
		this.rel_status = rel_status;
	}
	
}
