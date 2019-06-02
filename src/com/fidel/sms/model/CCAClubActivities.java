package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cca_club_activities")
public class CCAClubActivities {

	private int ca_id;
	private int clb_id;
	private String ca_activity;
	private String ca_activity_desc;
	private Date ca_datefrom;
	private Date ca_dateto;
	private int academic_year;
	private String clubhead_comment;
	private String ca_status;
	
	@Id
	@GeneratedValue
	public int getCa_id() {
		return ca_id;
	}
	public void setCa_id(int ca_id) {
		this.ca_id = ca_id;
	}
	public int getClb_id() {
		return clb_id;
	}
	public void setClb_id(int clb_id) {
		this.clb_id = clb_id;
	}
	public String getCa_activity() {
		return ca_activity;
	}
	public void setCa_activity(String ca_activity) {
		this.ca_activity = ca_activity;
	}
	public String getCa_activity_desc() {
		return ca_activity_desc;
	}
	public void setCa_activity_desc(String ca_activity_desc) {
		this.ca_activity_desc = ca_activity_desc;
	}
	public Date getCa_datefrom() {
		return ca_datefrom;
	}
	public void setCa_datefrom(Date ca_datefrom) {
		this.ca_datefrom = ca_datefrom;
	}
	public Date getCa_dateto() {
		return ca_dateto;
	}
	public void setCa_dateto(Date ca_dateto) {
		this.ca_dateto = ca_dateto;
	}
	public int getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
	public String getClubhead_comment() {
		return clubhead_comment;
	}
	public void setClubhead_comment(String clubhead_comment) {
		this.clubhead_comment = clubhead_comment;
	}
	public String getCa_status() {
		return ca_status;
	}
	public void setCa_status(String ca_status) {
		this.ca_status = ca_status;
	}	
}
