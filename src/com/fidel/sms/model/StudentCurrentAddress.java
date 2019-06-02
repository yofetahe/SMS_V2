package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud_current_address")
public class StudentCurrentAddress {

	private int sca_id;
	private String sub_city;
	private String kebele;
	private String house_no;
	private String home_phone_no;
	private String email;
	private String email_2;
	private String sca_status;
	private int si_id;
	
	@Id
	@GeneratedValue
	public int getSca_id() {
		return sca_id;
	}
	public void setSca_id(int sca_id) {
		this.sca_id = sca_id;
	}
	public String getSub_city() {
		return sub_city;
	}
	public void setSub_city(String sub_city) {
		this.sub_city = sub_city;
	}
	public String getKebele() {
		return kebele;
	}
	public void setKebele(String kebele) {
		this.kebele = kebele;
	}
	public String getHouse_no() {
		return house_no;
	}
	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	public String getHome_phone_no() {
		return home_phone_no;
	}
	public void setHome_phone_no(String home_phone_no) {
		this.home_phone_no = home_phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_2() {
		return email_2;
	}
	public void setEmail_2(String email_2) {
		this.email_2 = email_2;
	}
	public String getSca_status() {
		return sca_status;
	}
	public void setSca_status(String sca_status) {
		this.sca_status = sca_status;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	
}
