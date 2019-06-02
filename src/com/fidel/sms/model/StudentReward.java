package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud_reward")
public class StudentReward {

	private int sr_id;
	private String sr_type;
	private String sr_reason;
	private Date sr_date;
	private String sr_status;
	private int si_id;
	
	@Id
	@GeneratedValue
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}
	public String getSr_type() {
		return sr_type;
	}
	public void setSr_type(String sr_type) {
		this.sr_type = sr_type;
	}
	public String getSr_reason() {
		return sr_reason;
	}
	public void setSr_reason(String sr_reason) {
		this.sr_reason = sr_reason;
	}
	public Date getSr_date() {
		return sr_date;
	}
	public void setSr_date(Date sr_date) {
		this.sr_date = sr_date;
	}
	public String getSr_status() {
		return sr_status;
	}
	public void setSr_status(String sr_status) {
		this.sr_status = sr_status;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	
}
