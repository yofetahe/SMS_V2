package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam_result_comment")
public class ExamResultComment {

	private int erc_id;
	private int si_id;
	private int cl_id;
	private String erc_content;
	private int erc_given_by;
	private String erc_givenby_type;
	private Date erc_date;
	private int at_id;
	private int ac_year;
	private String erc_status;
	
	@Id
	@GeneratedValue
	public int getErc_id() {
		return erc_id;
	}
	public void setErc_id(int erc_id) {
		this.erc_id = erc_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public String getErc_content() {
		return erc_content;
	}
	public void setErc_content(String erc_content) {
		this.erc_content = erc_content;
	}
	public int getErc_given_by() {
		return erc_given_by;
	}
	public void setErc_given_by(int erc_given_by) {
		this.erc_given_by = erc_given_by;
	}
	public String getErc_givenby_type() {
		return erc_givenby_type;
	}
	public void setErc_givenby_type(String erc_givenby_type) {
		this.erc_givenby_type = erc_givenby_type;
	}
	public Date getErc_date() {
		return erc_date;
	}
	public void setErc_date(Date erc_date) {
		this.erc_date = erc_date;
	}
	public int getAt_id() {
		return at_id;
	}
	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}
	public int getAc_year() {
		return ac_year;
	}
	public void setAc_year(int ac_year) {
		this.ac_year = ac_year;
	}
	public String getErc_status() {
		return erc_status;
	}
	public void setErc_status(String erc_status) {
		this.erc_status = erc_status;
	}
}
