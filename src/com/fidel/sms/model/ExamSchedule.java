package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="exam_schedule")
public class ExamSchedule {

	@Id
	@GeneratedValue
	private int es_id;
	private int et_id;
	private String es_ethio_date;
	private String es_greg_date;
	private String time_from;
	private String time_to;
	private int es_fiscalyear;
	private int at_id;
	private int cl_id;
	private int sub_id;
	private String es_status;
	
	@Transient
	private SubjectClassRelation subjectClassRel;
	
	
	public int getEs_id() {
		return es_id;
	}
	public void setEs_id(int es_id) {
		this.es_id = es_id;
	}
	public int getEt_id() {
		return et_id;
	}
	public void setEt_id(int et_id) {
		this.et_id = et_id;
	}
	public String getEs_ethio_date() {
		return es_ethio_date;
	}
	public void setEs_ethio_date(String es_ethio_date) {
		this.es_ethio_date = es_ethio_date;
	}
	public String getEs_greg_date() {
		return es_greg_date;
	}
	public void setEs_greg_date(String es_greg_date) {
		this.es_greg_date = es_greg_date;
	}
	public String getTime_from() {
		return time_from;
	}
	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}
	public String getTime_to() {
		return time_to;
	}
	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}
	public int getEs_fiscalyear() {
		return es_fiscalyear;
	}
	public void setEs_fiscalyear(int es_fiscalyear) {
		this.es_fiscalyear = es_fiscalyear;
	}
	public int getAt_id() {
		return at_id;
	}
	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getEs_status() {
		return es_status;
	}
	public void setEs_status(String es_status) {
		this.es_status = es_status;
	}
	public SubjectClassRelation getSubjectClassRel() {
		return subjectClassRel;
	}
	public void setSubjectClassRel(SubjectClassRelation subjectClassRel) {
		this.subjectClassRel = subjectClassRel;
	}	
}
