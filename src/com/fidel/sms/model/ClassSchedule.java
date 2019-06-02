package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class_schedule")
public class ClassSchedule {
	
	private int cs_id;
	private int week_day;
	private int period;
	private int ta_id;
	private int cd_id;
	private int academic_year;
	
	@Id
	@GeneratedValue
	public int getCs_id() {
		return cs_id;
	}
	public void setCs_id(int cs_id) {
		this.cs_id = cs_id;
	}
	public int getWeek_day() {
		return week_day;
	}
	public void setWeek_day(int week_day) {
		this.week_day = week_day;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getTa_id() {
		return ta_id;
	}
	public void setTa_id(int ta_id) {
		this.ta_id = ta_id;
	}
	public int getCd_id() {
		return cd_id;
	}
	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}
	public int getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
}
