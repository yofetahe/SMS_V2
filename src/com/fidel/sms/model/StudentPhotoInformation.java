package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_photo_information")
public class StudentPhotoInformation {

	private int spi_id;
	private int si_id;
	private byte[] stud_photo;
	private String spi_status;
	
	@Id
	@GeneratedValue
	public int getSpi_id() {
		return spi_id;
	}
	public void setSpi_id(int spi_id) {
		this.spi_id = spi_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public byte[] getStud_photo() {
		return stud_photo;
	}
	public void setStud_photo(byte[] stud_photo) {
		this.stud_photo = stud_photo;
	}
	public String getSpi_status() {
		return spi_status;
	}
	public void setSpi_status(String spi_status) {
		this.spi_status = spi_status;
	}
	
}
