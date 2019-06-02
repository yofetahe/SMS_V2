package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="special_need_category")
public class SpecialNeedCategory {

	private int snc_id;
	private String snc_name;
	private double pay_amount;
	private int penality_max_date;
	private double penality_percent;
	private String snc_status;
	
	@Id
	@GeneratedValue
	public int getSnc_id() {
		return snc_id;
	}
	public void setSnc_id(int snc_id) {
		this.snc_id = snc_id;
	}
	public String getSnc_name() {
		return snc_name;
	}
	public void setSnc_name(String snc_name) {
		this.snc_name = snc_name;
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
	public String getSnc_status() {
		return snc_status;
	}
	public void setSnc_status(String snc_status) {
		this.snc_status = snc_status;
	}
	
}
