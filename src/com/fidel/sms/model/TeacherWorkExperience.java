package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tech_work_exp")
public class TeacherWorkExperience {

	private int twe_id;
	private String name_of_institute;
	private String job_title;
	private Date date_from;
	private Date date_to;
	private String twe_status;
	private int ti_id;
	
	@Id
	@GeneratedValue
	public int getTwe_id() {
		return twe_id;
	}
	public void setTwe_id(int twe_id) {
		this.twe_id = twe_id;
	}
	public String getName_of_institute() {
		return name_of_institute;
	}
	public void setName_of_institute(String name_of_institute) {
		this.name_of_institute = name_of_institute;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public Date getDate_from() {
		return date_from;
	}
	public void setDate_from(Date date_from) {
		this.date_from = date_from;
	}
	public Date getDate_to() {
		return date_to;
	}
	public void setDate_to(Date date_to) {
		this.date_to = date_to;
	}
	public String getTwe_status() {
		return twe_status;
	}
	public void setTwe_status(String twe_status) {
		this.twe_status = twe_status;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	
}
