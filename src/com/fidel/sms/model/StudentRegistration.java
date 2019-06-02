package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="stud_registration")
public class StudentRegistration {

	@Id
	@GeneratedValue
	private int sr_id;
	private int clcd_id;
	private int si_id;
	private int academic_year;
	private String stud_status;
	private String eduoff_reg;
	private String reg_status;
	private int reg_by;
	private Date reg_date;
	private int update_by;
	private Date update_date;
	
	
	@Transient
	private ClassTypeClassDetailRelation clcdRelation;
	@Transient
	private StudentInformation studentInformation;
	@Transient
	private StudentSpecialNeedRequired studentSpecialNeedRequired;
	
	
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}
	public int getClcd_id() {
		return clcd_id;
	}
	public void setClcd_id(int clcd_id) {
		this.clcd_id = clcd_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public int getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
	public String getStud_status() {
		return stud_status;
	}
	public void setStud_status(String stud_status) {
		this.stud_status = stud_status;
	}
	public String getEduoff_reg() {
		return eduoff_reg;
	}
	public void setEduoff_reg(String eduoff_reg) {
		this.eduoff_reg = eduoff_reg;
	}
	public String getReg_status() {
		return reg_status;
	}
	public void setReg_status(String reg_status) {
		this.reg_status = reg_status;
	}
	public int getReg_by() {
		return reg_by;
	}
	public void setReg_by(int reg_by) {
		this.reg_by = reg_by;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
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
	public ClassTypeClassDetailRelation getClcdRelation() {
		return clcdRelation;
	}
	public void setClcdRelation(ClassTypeClassDetailRelation clcdRelation) {
		this.clcdRelation = clcdRelation;
	}
	public StudentInformation getStudentInformation() {
		return studentInformation;
	}
	public void setStudentInformation(StudentInformation studentInformation) {
		this.studentInformation = studentInformation;
	}
	public StudentSpecialNeedRequired getStudentSpecialNeedRequired() {
		return studentSpecialNeedRequired;
	}
	public void setStudentSpecialNeedRequired(StudentSpecialNeedRequired studentSpecialNeedRequired) {
		this.studentSpecialNeedRequired = studentSpecialNeedRequired;
	}
	
}
