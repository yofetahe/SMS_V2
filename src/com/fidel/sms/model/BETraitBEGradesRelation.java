package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="btraits_bgrades_rel")
public class BETraitBEGradesRelation {
		
	private int btbg_id;
	private int bt_id;
	private int bg_id;
	private String rel_status;
	
	@Id
	@GeneratedValue
	public int getBtbg_id() {
		return btbg_id;
	}
	public void setBtbg_id(int btbg_id) {
		this.btbg_id = btbg_id;
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
	public String getRel_status() {
		return rel_status;
	}
	public void setRel_status(String rel_status) {
		this.rel_status = rel_status;
	}
}
