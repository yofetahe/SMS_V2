package com.fidel.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="clist_cdetail_rel")
public class ClassTypeClassDetailRelation {
	
	@Id
	@GeneratedValue
	private int clcd_id;
	private int cl_id;
	private int cd_id;
	@Column(name="cl_capacity")
	private int class_capacity;
	private String rel_status;
	
	@Transient
	private ClassType classType;
	@Transient
	private ClassDetail classDetail;
	
	public int getClcd_id() {
		return clcd_id;
	}
	public void setClcd_id(int clcd_id) {
		this.clcd_id = clcd_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public int getCd_id() {
		return cd_id;
	}
	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}
	public int getClass_capacity() {
		return class_capacity;
	}
	public void setClass_capacity(int class_capacity) {
		this.class_capacity = class_capacity;
	}
	public String getRel_status() {
		return rel_status;
	}
	public void setRel_status(String rel_status) {
		this.rel_status = rel_status;
	}
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	public ClassDetail getClassDetail() {
		return classDetail;
	}
	public void setClassDetail(ClassDetail classDetail) {
		this.classDetail = classDetail;
	}
}
