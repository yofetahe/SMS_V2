package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cca_member")
public class CCAMember {

	private int cm_id;
	private int mc_id;
	private int m_id;
	private int clb_id;
	private String cm_reasontojoin;
	private String cm_evaluation;
	private int academic_year;
	private String cm_status;
	
	@Id
	@GeneratedValue
	public int getCm_id() {
		return cm_id;
	}
	public void setCm_id(int cm_id) {
		this.cm_id = cm_id;
	}
	public int getMc_id() {
		return mc_id;
	}
	public void setMc_id(int mc_id) {
		this.mc_id = mc_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getClb_id() {
		return clb_id;
	}
	public void setClb_id(int clb_id) {
		this.clb_id = clb_id;
	}
	public String getCm_reasontojoin() {
		return cm_reasontojoin;
	}
	public void setCm_reasontojoin(String cm_reasontojoin) {
		this.cm_reasontojoin = cm_reasontojoin;
	}
	public String getCm_evaluation() {
		return cm_evaluation;
	}
	public void setCm_evaluation(String cm_evaluation) {
		this.cm_evaluation = cm_evaluation;
	}
	public int getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
	public String getCm_status() {
		return cm_status;
	}
	public void setCm_status(String cm_status) {
		this.cm_status = cm_status;
	}
}
