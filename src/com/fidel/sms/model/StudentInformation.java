package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="stud_information")
public class StudentInformation {

	@Id
	@GeneratedValue
	private int si_id;
	private String fname;
	private String mname;
	private String gname;
	private String mother_name;
	private String sex;
	private String dob;
	private String pob;
	private String nationality;
	private String id_no;
	private String photo_name;
	private String photo_path;
	private String si_status;
	private int create_by;
	private Date create_date;
	private int update_by;
	private Date update_date;
	
	@Transient
	private StudentRegistration studRegistration;	
	@Transient
	private String selectedBroSisIdList;
	@Transient
	private StudentEmergencyContact studentEmergencyContact;
	
	public StudentInformation(){}
	
	public StudentInformation(int si_id, String fname, String mname, String gname, String mother_name, String sex,
			String dob, String pob, String nationality, String id_no, String photo_name, String photo_path,
			String si_status){
		
		super();
		this.si_id = si_id;
		this.fname = fname;
		this.mname = mname;
		this.gname = gname;
		this.mother_name = mother_name;
		this.sex = sex;
		this.dob = dob;
		this.pob = pob;
		this.nationality = nationality;
		this.id_no = id_no;
		this.photo_name = photo_name;
		this.photo_path = photo_path;
		this.si_status = si_status;
	}
	
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getMother_name() {
		return mother_name;
	}
	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPob() {
		return pob;
	}
	public void setPob(String pob) {
		this.pob = pob;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getId_no() {
		return id_no;
	}
	public void setId_no(String id_no) {
		this.id_no = id_no;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public String getSi_status() {
		return si_status;
	}
	public void setSi_status(String si_status) {
		this.si_status = si_status;
	}
	public int getCreate_by() {
		return create_by;
	}
	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
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
	public StudentRegistration getStudRegistration() {
		return studRegistration;
	}
	public void setStudRegistration(StudentRegistration studRegistration) {
		this.studRegistration = studRegistration;
	}

	public String getSelectedBroSisIdList() {
		return selectedBroSisIdList;
	}

	public void setSelectedBroSisIdList(String selectedBroSisIdList) {
		this.selectedBroSisIdList = selectedBroSisIdList;
	}

	public StudentEmergencyContact getStudentEmergencyContact() {
		return studentEmergencyContact;
	}

	public void setStudentEmergencyContact(StudentEmergencyContact studentEmergencyContact) {
		this.studentEmergencyContact = studentEmergencyContact;
	}	
}
