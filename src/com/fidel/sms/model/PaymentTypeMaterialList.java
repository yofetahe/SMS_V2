package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_type_material_list")
public class PaymentTypeMaterialList {

	private int ptm_id;
	private String ptm_name;
	private String ptm_desc;
	private String ptm_status;
	
	@Id
	@GeneratedValue
	public int getPtm_id() {
		return ptm_id;
	}
	public void setPtm_id(int ptm_id) {
		this.ptm_id = ptm_id;
	}
	public String getPtm_name() {
		return ptm_name;
	}
	public void setPtm_name(String ptm_name) {
		this.ptm_name = ptm_name;
	}
	public String getPtm_desc() {
		return ptm_desc;
	}
	public void setPtm_desc(String ptm_desc) {
		this.ptm_desc = ptm_desc;
	}
	public String getPtm_status() {
		return ptm_status;
	}
	public void setPtm_status(String ptm_status) {
		this.ptm_status = ptm_status;
	}	
}
