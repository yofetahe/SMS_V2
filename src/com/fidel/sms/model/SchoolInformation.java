package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="school_information")
public class SchoolInformation {

	private int sch_inf_id;
	private String school_name;
	private String slogan;
	private byte[] school_logo;
	private String tin_num;
	private String telephone;
	private String fax;
	private String web;
	private String email;
	private String pobox;
	private String fiscal_machine_no;
	private String sch_inf_status;
	
	@Id
	@GeneratedValue
	public int getSch_inf_id() {
		return sch_inf_id;
	}
	public void setSch_inf_id(int sch_inf_id) {
		this.sch_inf_id = sch_inf_id;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public byte[] getSchool_logo() {
		return school_logo;
	}
	public void setSchool_logo(byte[] school_logo) {
		this.school_logo = school_logo;
	}
	public String getTin_num() {
		return tin_num;
	}
	public void setTin_num(String tin_num) {
		this.tin_num = tin_num;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPobox() {
		return pobox;
	}
	public void setPobox(String pobox) {
		this.pobox = pobox;
	}
	public String getFiscal_machine_no() {
		return fiscal_machine_no;
	}
	public void setFiscal_machine_no(String fiscal_machine_no) {
		this.fiscal_machine_no = fiscal_machine_no;
	}
	public String getSch_inf_status() {
		return sch_inf_status;
	}
	public void setSch_inf_status(String sch_inf_status) {
		this.sch_inf_status = sch_inf_status;
	}	
}
