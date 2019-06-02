package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="exam_sub_rel")
public class ExamSubjectRelation {
	
	@Id
	@GeneratedValue
	private int exsub_id;
	private int et_id;
	private int subcl_id;
	private double total_mark;
	private double pass_mark;
	private String rel_status;
	
	@Transient
	private SubjectClassRelation subjectClassRel;
	
	public int getExsub_id() {
		return exsub_id;
	}
	public void setExsub_id(int exsub_id) {
		this.exsub_id = exsub_id;
	}
	public int getEt_id() {
		return et_id;
	}
	public void setEt_id(int et_id) {
		this.et_id = et_id;
	}
	public int getSubcl_id() {
		return subcl_id;
	}
	public void setSubcl_id(int subcl_id) {
		this.subcl_id = subcl_id;
	}
	public double getTotal_mark() {
		return total_mark;
	}
	public void setTotal_mark(double total_mark) {
		this.total_mark = total_mark;
	}
	public double getPass_mark() {
		return pass_mark;
	}
	public void setPass_mark(double pass_mark) {
		this.pass_mark = pass_mark;
	}
	public String getRel_status() {
		return rel_status;
	}
	public void setRel_status(String rel_status) {
		this.rel_status = rel_status;
	}
	public SubjectClassRelation getSubjectClassRel() {
		return subjectClassRel;
	}
	public void setSubjectClassRel(SubjectClassRelation subjectClassRel) {
		this.subjectClassRel = subjectClassRel;
	}
}
