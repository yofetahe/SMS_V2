package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="btraits_class_rel")
public class BETraitsClassRelation {
	
	private int btc_id;
	private int cl_id;
	private int bt_id;
	private String rel_status;
	
	@Id
	@GeneratedValue
	public int getBtc_id() {
		return btc_id;
	}
	public void setBtc_id(int btc_id) {
		this.btc_id = btc_id;
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
	public String getRel_status() {
		return rel_status;
	}
	public void setRel_status(String rel_status) {
		this.rel_status = rel_status;
	}	
}
