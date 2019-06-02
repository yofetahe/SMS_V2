package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_type")
public class PaymentType {

	private int pt_id;
	private String pt_name;
	private String pt_status;
	
	@Id
	@GeneratedValue
	public int getPt_id() {
		return pt_id;
	}
	public void setPt_id(int pt_id) {
		this.pt_id = pt_id;
	}
	public String getPt_name() {
		return pt_name;
	}
	public void setPt_name(String pt_name) {
		this.pt_name = pt_name;
	}
	public String getPt_status() {
		return pt_status;
	}
	public void setPt_status(String pt_status) {
		this.pt_status = pt_status;
	}	
}
