package com.fidel.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beval_stud_result")
public class BEvaluationStudentResult {
	
	private int bsr_id;
	private int si_id;
	private int cl_id;
	private int bt_id;
	private int bg_id;
	private int academic_year;
	@Column(name="qr_id")
	private int at_id;
	private String bsr_status;
	
	@Id
	@GeneratedValue
	public int getBsr_id() {
		return bsr_id;
	}
	public void setBsr_id(int bsr_id) {
		this.bsr_id = bsr_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public int getBt_id() {
		return bt_id;
	}
	public void setBt_id(int bt_id) {
		this.bt_id = bt_id;
	}
	public int getBg_id() {
		return bg_id;
	}
	public void setBg_id(int bg_id) {
		this.bg_id = bg_id;
	}
	public int getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
	public int getAt_id() {
		return at_id;
	}
	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}
	public String getBsr_status() {
		return bsr_status;
	}
	public void setBsr_status(String bsr_status) {
		this.bsr_status = bsr_status;
	}
}
