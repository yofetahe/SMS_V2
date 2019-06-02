package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam_default_comment")
public class ExamDefaultComment {

	private int edc_id;
	private String edc_content;
	private double rank_from;
	private double rank_to;
	private String edc_status;
	
	@Id
	@GeneratedValue
	public int getEdc_id() {
		return edc_id;
	}
	public void setEdc_id(int edc_id) {
		this.edc_id = edc_id;
	}
	public String getEdc_content() {
		return edc_content;
	}
	public void setEdc_content(String edc_content) {
		this.edc_content = edc_content;
	}
	public double getRank_from() {
		return rank_from;
	}
	public void setRank_from(double rank_from) {
		this.rank_from = rank_from;
	}
	public double getRank_to() {
		return rank_to;
	}
	public void setRank_to(double rank_to) {
		this.rank_to = rank_to;
	}
	public String getEdc_status() {
		return edc_status;
	}
	public void setEdc_status(String edc_status) {
		this.edc_status = edc_status;
	}	
}
