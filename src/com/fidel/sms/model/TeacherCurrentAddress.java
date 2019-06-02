package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tech_current_address")
public class TeacherCurrentAddress {

	private int tca_id;
	private String sub_city;
	private String kebele;
	private String house_no;
	private String house_phone_no;
	private String mobile_no;
	private String email;
	private String tca_status;
	private int ti_id;
	
	@Id
	@GeneratedValue
	public int getTca_id() {
		return tca_id;
	}
	public void setTca_id(int tca_id) {
		this.tca_id = tca_id;
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
	public String getHouse_phone_no() {
		return house_phone_no;
	}
	public void setHouse_phone_no(String house_phone_no) {
		this.house_phone_no = house_phone_no;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTca_status() {
		return tca_status;
	}
	public void setTca_status(String tca_status) {
		this.tca_status = tca_status;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	
}
