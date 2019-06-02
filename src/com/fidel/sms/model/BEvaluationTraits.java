package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beval_traits")
public class BEvaluationTraits {

	private int bt_id;
	private String bt_title;
	private String bt_desc;
	private String bt_status;
	
	@Id
	@GeneratedValue
	public int getBt_id() {
		return bt_id;
	}
	public void setBt_id(int bt_id) {
		this.bt_id = bt_id;
	}
	public String getBt_title() {
		return bt_title;
	}
	public void setBt_title(String bt_title) {
		this.bt_title = bt_title;
	}
	public String getBt_desc() {
		return bt_desc;
	}
	public void setBt_desc(String bt_desc) {
		this.bt_desc = bt_desc;
	}
	public String getBt_status() {
		return bt_status;
	}
	public void setBt_status(String bt_status) {
		this.bt_status = bt_status;
	}	
}
