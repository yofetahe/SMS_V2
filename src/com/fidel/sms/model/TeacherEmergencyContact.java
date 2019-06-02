package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tech_emergency_contact")
public class TeacherEmergencyContact {

	private int tec_id;
	private String cont_name;
	private String relationship;
	private String mobile_no;
	private String home_phone_no;
	private String office_phone_no;
	private String tec_status;
	private int ti_id;
	
	@Id
	@GeneratedValue
	public int getTec_id() {
		return tec_id;
	}
	public void setTec_id(int tec_id) {
		this.tec_id = tec_id;
	}
	public String getCont_name() {
		return cont_name;
	}
	public void setCont_name(String cont_name) {
		this.cont_name = cont_name;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getHome_phone_no() {
		return home_phone_no;
	}
	public void setHome_phone_no(String home_phone_no) {
		this.home_phone_no = home_phone_no;
	}
	public String getOffice_phone_no() {
		return office_phone_no;
	}
	public void setOffice_phone_no(String office_phone_no) {
		this.office_phone_no = office_phone_no;
	}
	public String getTec_status() {
		return tec_status;
	}
	public void setTec_status(String tec_status) {
		this.tec_status = tec_status;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	
}
