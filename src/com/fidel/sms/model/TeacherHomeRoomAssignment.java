package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tech_hroom_assignment")
public class TeacherHomeRoomAssignment {

	private int thra_id;
	private int ti_id;
	private int cl_id;
	private int cd_id;
	private int academic_year;
	private String thra_status;
	
	@Id
	@GeneratedValue
	public int getThra_id() {
		return thra_id;
	}
	public void setThra_id(int thra_id) {
		this.thra_id = thra_id;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
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
	public String getThra_status() {
		return thra_status;
	}
	public void setThra_status(String thra_status) {
		this.thra_status = thra_status;
	}
	
}
