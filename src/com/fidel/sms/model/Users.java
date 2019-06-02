package com.fidel.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user_account")
public class Users {
		
	private int ua_id;    
    private String user_name;
    private String password;
    private String ua_status;
    private int ti_id;
    private int si_id;
    private int nti_id;
    private int ut_id;
    
    @Transient
    private String oldPassword;
   
    @Id
	@GeneratedValue    
	public int getUa_id() {
		return ua_id;
	}
	public void setUa_id(int ua_id) {
		this.ua_id = ua_id;
	}
	public String getUa_status() {
		return ua_status;
	}
	public void setUa_status(String ua_status) {
		this.ua_status = ua_status;
	}
	public int getTi_id() {
		return ti_id;
	}
	public void setTi_id(int ti_id) {
		this.ti_id = ti_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public int getNti_id() {
		return nti_id;
	}
	public void setNti_id(int nti_id) {
		this.nti_id = nti_id;
	}
	public int getUt_id() {
		return ut_id;
	}
	public void setUt_id(int ut_id) {
		this.ut_id = ut_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
}
