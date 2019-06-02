package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud_special_need_required")
public class StudentSpecialNeedRequired {

	private int ssnr_id;
	private int si_id;
	private int snc_id;
	private int ac_year;
	private String ssnr_status;
	private int create_by;
	private Date create_date;
	private int update_by;
	private Date update_date;
	
	@Id
	@GeneratedValue
	public int getSsnr_id() {
		return ssnr_id;
	}
	public void setSsnr_id(int ssnr_id) {
		this.ssnr_id = ssnr_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public int getSnc_id() {
		return snc_id;
	}
	public void setSnc_id(int snc_id) {
		this.snc_id = snc_id;
	}
	public int getAc_year() {
		return ac_year;
	}
	public void setAc_year(int ac_year) {
		this.ac_year = ac_year;
	}
	public String getSsnr_status() {
		return ssnr_status;
	}
	public void setSsnr_status(String ssnr_status) {
		this.ssnr_status = ssnr_status;
	}
	public int getCreate_by() {
		return create_by;
	}
	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(int update_by) {
		this.update_by = update_by;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
}
