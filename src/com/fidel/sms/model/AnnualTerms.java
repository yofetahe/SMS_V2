package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="annual_terms")
public class AnnualTerms {
	
	@Id
	@GeneratedValue
	private int at_id;
	private String at_name;
	@Column(name="at_from")
	private Date at_date_from;
	@Column(name="at_to")
	private Date at_date_to;
	private String at_type;
	private String at_status;
	
	public int getAt_id() {
		return at_id;
	}
	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}
	public String getAt_name() {
		return at_name;
	}
	public void setAt_name(String at_name) {
		this.at_name = at_name;
	}
	public Date getAt_date_from() {
		return at_date_from;
	}
	public void setAt_date_from(Date at_date_from) {
		this.at_date_from = at_date_from;
	}
	public Date getAt_date_to() {
		return at_date_to;
	}
	public void setAt_date_to(Date at_date_to) {
		this.at_date_to = at_date_to;
	}
	public String getAt_status() {
		return at_status;
	}
	public void setAt_status(String at_status) {
		this.at_status = at_status;
	}
	public String getAt_type() {
		return at_type;
	}
	public void setAt_type(String at_type) {
		this.at_type = at_type;
	}
}
