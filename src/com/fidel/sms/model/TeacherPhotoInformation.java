package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher_photo_information")
public class TeacherPhotoInformation {

	@Id
	@GeneratedValue
	private int tpi_id;
	private int ti_id;
	private byte[] teacher_photo;
	private String tpi_status;
	
	public int getTpi_id() {
		return tpi_id;
	}
	public void setTpi_id(int tpi_id) {
		this.tpi_id = tpi_id;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	public byte[] getTeacher_photo() {
		return teacher_photo;
	}
	public void setTeacher_photo(byte[] teacher_photo) {
		this.teacher_photo = teacher_photo;
	}
	public String getTpi_status() {
		return tpi_status;
	}
	public void setTpi_status(String tpi_status) {
		this.tpi_status = tpi_status;
	}	
}
