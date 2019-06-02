package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="exam_subcl_grade_rel")
public class ExamSubjectClassGradeRelation {

	@Id
	@GeneratedValue
	private int escg_id;
	private int subcl_id;
	private int eg_id;
	private double grade_from;
	private double grade_to;
	private String escg_status;
	
	@Transient
	private SubjectClassRelation subjectClassRel;
	
	public int getEscg_id() {
		return escg_id;
	}
	public void setEscg_id(int escg_id) {
		this.escg_id = escg_id;
	}
	public int getSubcl_id() {
		return subcl_id;
	}
	public void setSubcl_id(int subcl_id) {
		this.subcl_id = subcl_id;
	}
	public int getEg_id() {
		return eg_id;
	}
	public void setEg_id(int eg_id) {
		this.eg_id = eg_id;
	}
	public double getGrade_from() {
		return grade_from;
	}
	public void setGrade_from(double grade_from) {
		this.grade_from = grade_from;
	}
	public double getGrade_to() {
		return grade_to;
	}
	public void setGrade_to(double grade_to) {
		this.grade_to = grade_to;
	}
	public String getEscg_status() {
		return escg_status;
	}
	public void setEscg_status(String escg_status) {
		this.escg_status = escg_status;
	}
	public SubjectClassRelation getSubjectClassRel() {
		return subjectClassRel;
	}
	public void setSubjectClassRel(SubjectClassRelation subjectClassRel) {
		this.subjectClassRel = subjectClassRel;
	}
}
