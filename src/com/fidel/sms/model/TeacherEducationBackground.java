package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tech_edu_background")
public class TeacherEducationBackground {

	private int teb_id;
	private String field_of_study;
	private String name_of_institute;
	private Date graduation_date;
	private String award;
	private int ti_id;
	
	@Id
	@GeneratedValue
	public int getTeb_id() {
		return teb_id;
	}
	public void setTeb_id(int teb_id) {
		this.teb_id = teb_id;
	}
	public String getField_of_study() {
		return field_of_study;
	}
	public void setField_of_study(String field_of_study) {
		this.field_of_study = field_of_study;
	}
	public String getName_of_institute() {
		return name_of_institute;
	}
	public void setName_of_institute(String name_of_institute) {
		this.name_of_institute = name_of_institute;
	}
	public Date getGraduation_date() {
		return graduation_date;
	}
	public void setGraduation_date(Date graduation_date) {
		this.graduation_date = graduation_date;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	
}
