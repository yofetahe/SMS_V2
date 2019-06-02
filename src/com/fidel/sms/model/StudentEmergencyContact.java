package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="stud_emergency_contact")
public class StudentEmergencyContact {

	@Id
	@GeneratedValue
	private int sec_id;
	private String cont_name;
	private String relationship;
	private String mob_no;
	private String office_phone_no;
	private String home_phone_no;
	private String sec_status;
	private int si_id;
	
	@Transient
	private String cont_name_2;
	@Transient
	private String relationship_2;
	@Transient
	private String mob_no_2;
	@Transient
	private String office_phone_no_2;
	@Transient
	private String home_phone_no_2;
	
	
	public int getSec_id() {
		return sec_id;
	}
	public void setSec_id(int sec_id) {
		this.sec_id = sec_id;
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
	public String getMob_no() {
		return mob_no;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public String getOffice_phone_no() {
		return office_phone_no;
	}
	public void setOffice_phone_no(String office_phone_no) {
		this.office_phone_no = office_phone_no;
	}
	public String getHome_phone_no() {
		return home_phone_no;
	}
	public void setHome_phone_no(String home_phone_no) {
		this.home_phone_no = home_phone_no;
	}
	public String getSec_status() {
		return sec_status;
	}
	public void setSec_status(String sec_status) {
		this.sec_status = sec_status;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public String getCont_name_2() {
		return cont_name_2;
	}
	public void setCont_name_2(String cont_name_2) {
		this.cont_name_2 = cont_name_2;
	}
	public String getRelationship_2() {
		return relationship_2;
	}
	public void setRelationship_2(String relationship_2) {
		this.relationship_2 = relationship_2;
	}
	public String getMob_no_2() {
		return mob_no_2;
	}
	public void setMob_no_2(String mob_no_2) {
		this.mob_no_2 = mob_no_2;
	}
	public String getOffice_phone_no_2() {
		return office_phone_no_2;
	}
	public void setOffice_phone_no_2(String office_phone_no_2) {
		this.office_phone_no_2 = office_phone_no_2;
	}
	public String getHome_phone_no_2() {
		return home_phone_no_2;
	}
	public void setHome_phone_no_2(String home_phone_no_2) {
		this.home_phone_no_2 = home_phone_no_2;
	}
	
}
