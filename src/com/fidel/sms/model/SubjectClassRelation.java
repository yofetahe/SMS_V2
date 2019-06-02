package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="subject_class_rel")
public class SubjectClassRelation {

	@Id
	@GeneratedValue
	private int subcl_id;
	private int sub_id;
	private int cl_id;
	private String add_status;
	private String convert_to_grade;
	private String rel_status;
	
	@Transient
	private SubjectType subjectType;
	
	public int getSubcl_id() {
		return subcl_id;
	}
	public void setSubcl_id(int subcl_id) {
		this.subcl_id = subcl_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public String getAdd_status() {
		return add_status;
	}
	public void setAdd_status(String add_status) {
		this.add_status = add_status;
	}
	public String getConvert_to_grade() {
		return convert_to_grade;
	}
	public void setConvert_to_grade(String convert_to_grade) {
		this.convert_to_grade = convert_to_grade;
	}
	public String getRel_status() {
		return rel_status;
	}
	public void setRel_status(String rel_status) {
		this.rel_status = rel_status;
	}
	public SubjectType getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}
	
}
