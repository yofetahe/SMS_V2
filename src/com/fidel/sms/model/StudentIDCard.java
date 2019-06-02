package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud_id_card")
public class StudentIDCard {

	private int sid_id;
	private int si_id;
	private String sid_status;
	private Date print_date;
	private Date return_date;
	
	@Id
	@GeneratedValue
	public int getSid_id() {
		return sid_id;
	}
	public void setSid_id(int sid_id) {
		this.sid_id = sid_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public String getSid_status() {
		return sid_status;
	}
	public void setSid_status(String sid_status) {
		this.sid_status = sid_status;
	}
	public Date getPrint_date() {
		return print_date;
	}
	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
}
