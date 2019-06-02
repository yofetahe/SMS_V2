package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paymetn_material_class_rel")
public class PaymentMaterialClassRelation {
	
	private int pmc_id;
	private int ptm_id;
	private int cl_id;
	private double pay_amount;
	private String pmc_status;
	
	@Id
	@GeneratedValue
	public int getPmc_id() {
		return pmc_id;
	}
	public void setPmc_id(int pmc_id) {
		this.pmc_id = pmc_id;
	}
	public int getPtm_id() {
		return ptm_id;
	}
	public void setPtm_id(int ptm_id) {
		this.ptm_id = ptm_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public double getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(double pay_amount) {
		this.pay_amount = pay_amount;
	}
	public String getPmc_status() {
		return pmc_status;
	}
	public void setPmc_status(String pmc_status) {
		this.pmc_status = pmc_status;
	}

}
