package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_fine")
public class PaymentFine {
	
	private int pf_id;
	private int pt_id;
	private double fine_amount;
	private int day_interval;
	private String pf_status;
	
	@Id
	@GeneratedValue
	public int getPf_id() {
		return pf_id;
	}
	public void setPf_id(int pf_id) {
		this.pf_id = pf_id;
	}
	public int getPt_id() {
		return pt_id;
	}
	public void setPt_id(int pt_id) {
		this.pt_id = pt_id;
	}
	public double getFine_amount() {
		return fine_amount;
	}
	public void setFine_amount(double fine_amount) {
		this.fine_amount = fine_amount;
	}
	public int getDay_interval() {
		return day_interval;
	}
	public void setDay_interval(int day_interval) {
		this.day_interval = day_interval;
	}
	public String getPf_status() {
		return pf_status;
	}
	public void setPf_status(String pf_status) {
		this.pf_status = pf_status;
	}

}
