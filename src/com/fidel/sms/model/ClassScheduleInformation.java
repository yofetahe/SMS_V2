package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class_schedule_info")
public class ClassScheduleInformation {

	private int csi_id;
	private int noof_period;
	private int noof_days;
	private String csi_status;
	
	@Id
	@GeneratedValue
	public int getCsi_id() {
		return csi_id;
	}
	public void setCsi_id(int csi_id) {
		this.csi_id = csi_id;
	}
	public int getNoof_period() {
		return noof_period;
	}
	public void setNoof_period(int noof_period) {
		this.noof_period = noof_period;
	}
	public int getNoof_days() {
		return noof_days;
	}
	public void setNoof_days(int noof_days) {
		this.noof_days = noof_days;
	}
	public String getCsi_status() {
		return csi_status;
	}
	public void setCsi_status(String csi_status) {
		this.csi_status = csi_status;
	}	
}
