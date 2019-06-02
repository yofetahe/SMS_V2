package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="da_attendnace")
public class DAAttendance {
	
	@Id
	@GeneratedValue
	private int att_id;
	private int si_id;
	private Date att_date;
	private String att_reason;
	private int clcd_id;
	private int academic_year;
	private int ti_id;
	private int attype_id;
	private int at_id;
	private String att_status;
	
	@Transient
	private ClassTypeClassDetailRelation cTypeCDetailRel;
	@Transient
	private String attendance_date;
	
	public int getAtt_id() {
		return att_id;
	}
	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public Date getAtt_date() {
		return att_date;
	}
	public void setAtt_date(Date att_date) {
		this.att_date = att_date;
	}
	public String getAtt_reason() {
		return att_reason;
	}
	public void setAtt_reason(String att_reason) {
		this.att_reason = att_reason;
	}
	public int getClcd_id() {
		return clcd_id;
	}
	public void setClcd_id(int clcd_id) {
		this.clcd_id = clcd_id;
	}
	public int getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	public int getAttype_id() {
		return attype_id;
	}
	public void setAttype_id(int attype_id) {
		this.attype_id = attype_id;
	}
	public int getAt_id() {
		return at_id;
	}
	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}
	public String getAtt_status() {
		return att_status;
	}
	public void setAtt_status(String att_status) {
		this.att_status = att_status;
	}
	public ClassTypeClassDetailRelation getcTypeCDetailRel() {
		return cTypeCDetailRel;
	}
	public void setcTypeCDetailRel(ClassTypeClassDetailRelation cTypeCDetailRel) {
		this.cTypeCDetailRel = cTypeCDetailRel;
	}
	public String getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(String attendance_date) {
		this.attendance_date = attendance_date;
	}	
}
