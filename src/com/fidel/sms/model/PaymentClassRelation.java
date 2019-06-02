package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_class_rel")
public class PaymentClassRelation {
	
	private int pc_id;
	private int cl_id;
	private int pt_id;
	private double pay_amount;
	private int penality_max_date;
	private double penality_percent;
	private int academic_year;
	private int sm_id;
	private String pc_status;
	
	@Id
	@GeneratedValue
	public int getPc_id() {
		return pc_id;
	}
	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public int getPt_id() {
		return pt_id;
	}
	public void setPt_id(int pt_id) {
		this.pt_id = pt_id;
	}
	public double getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(double pay_amount) {
		this.pay_amount = pay_amount;
	}
	public int getPenality_max_date() {
		return penality_max_date;
	}
	public void setPenality_max_date(int penality_max_date) {
		this.penality_max_date = penality_max_date;
	}
	public double getPenality_percent() {
		return penality_percent;
	}
	public void setPenality_percent(double penality_percent) {
		this.penality_percent = penality_percent;
	}
	public int getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
	public int getSm_id() {
		return sm_id;
	}
	public void setSm_id(int sm_id) {
		this.sm_id = sm_id;
	}
	public String getPc_status() {
		return pc_status;
	}
	public void setPc_status(String pc_status) {
		this.pc_status = pc_status;
	}	
}
