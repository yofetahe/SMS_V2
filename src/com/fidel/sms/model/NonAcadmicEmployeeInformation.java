package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="non_teacher_information")
public class NonAcadmicEmployeeInformation {
	
	private int nti_id;
	private String nti_fname;
	private String nti_mname;
	private String nti_gname;
	private String nti_position;
	private String nti_sex;
	private String nti_email;
	private String nti_id_no;
	private String nti_status;
	
	@Id
	@GeneratedValue
	public int getNti_id() {
		return nti_id;
	}
	public void setNti_id(int nti_id) {
		this.nti_id = nti_id;
	}
	public String getNti_fname() {
		return nti_fname;
	}
	public void setNti_fname(String nti_fname) {
		this.nti_fname = nti_fname;
	}
	public String getNti_mname() {
		return nti_mname;
	}
	public void setNti_mname(String nti_mname) {
		this.nti_mname = nti_mname;
	}
	public String getNti_gname() {
		return nti_gname;
	}
	public void setNti_gname(String nti_gname) {
		this.nti_gname = nti_gname;
	}
	public String getNti_position() {
		return nti_position;
	}
	public void setNti_position(String nti_position) {
		this.nti_position = nti_position;
	}
	public String getNti_sex() {
		return nti_sex;
	}
	public void setNti_sex(String nti_sex) {
		this.nti_sex = nti_sex;
	}
	public String getNti_email() {
		return nti_email;
	}
	public void setNti_email(String nti_email) {
		this.nti_email = nti_email;
	}
	public String getNti_id_no() {
		return nti_id_no;
	}
	public void setNti_id_no(String nti_id_no) {
		this.nti_id_no = nti_id_no;
	}
	public String getNti_status() {
		return nti_status;
	}
	public void setNti_status(String nti_status) {
		this.nti_status = nti_status;
	}
}
