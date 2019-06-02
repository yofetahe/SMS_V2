package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_month")
public class PaymentMonth {

	private int month_id;
	private String month;
	private String short_name;
	private int month_index;
	
	@Id
	@GeneratedValue
	public int getMonth_id() {
		return month_id;
	}
	public void setMonth_id(int month_id) {
		this.month_id = month_id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public int getMonth_index() {
		return month_index;
	}
	public void setMonth_index(int month_index) {
		this.month_index = month_index;
	}
	
}
