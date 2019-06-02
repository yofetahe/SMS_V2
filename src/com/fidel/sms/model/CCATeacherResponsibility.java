package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cca_teacher_responsibility")
public class CCATeacherResponsibility {

	private int tr_id;
	private int ti_id;
	private int role_id;
	private int responsibility_id;
	private int academic_year;
	private String tr_status;
	
	@Id
	@GeneratedValue
	public int getTr_id() {
		return tr_id;
	}
	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getResponsibility_id() {
		return responsibility_id;
	}
	public void setResponsibility_id(int responsibility_id) {
		this.responsibility_id = responsibility_id;
	}
	public int getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
	public String getTr_status() {
		return tr_status;
	}
	public void setTr_status(String tr_status) {
		this.tr_status = tr_status;
	}	
}
