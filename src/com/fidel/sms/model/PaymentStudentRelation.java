package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_stud_rel")
public class PaymentStudentRelation {

	private int paystud_id;
	private int si_id;
	private int pc_id;
	private int pmc_id;
	private int snc_id;
	private double penality_amount;
	private double total_payment;
	private Date payment_date;
	private String fm_receipt_no;
	private String cust_vat_reg_no;
	private String cust_tin;
	private String payment_mode;
	private String cheque_no;
	private int month_id;
	private int ac_year;
	private int sm_id;
	private String reg_fee;	
	private String paystud_status;
	private int create_by;
	private Date create_date;
	private int update_by;
	private Date update_date;
	
	@Id
	@GeneratedValue
	public int getPaystud_id() {
		return paystud_id;
	}
	public void setPaystud_id(int paystud_id) {
		this.paystud_id = paystud_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public int getPc_id() {
		return pc_id;
	}
	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}
	public int getPmc_id() {
		return pmc_id;
	}
	public void setPmc_id(int pmc_id) {
		this.pmc_id = pmc_id;
	}
	public int getSnc_id() {
		return snc_id;
	}
	public void setSnc_id(int snc_id) {
		this.snc_id = snc_id;
	}
	public double getPenality_amount() {
		return penality_amount;
	}
	public void setPenality_amount(double penality_amount) {
		this.penality_amount = penality_amount;
	}
	public double getTotal_payment() {
		return total_payment;
	}
	public void setTotal_payment(double total_payment) {
		this.total_payment = total_payment;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public String getFm_receipt_no() {
		return fm_receipt_no;
	}
	public void setFm_receipt_no(String fm_receipt_no) {
		this.fm_receipt_no = fm_receipt_no;
	}
	public String getCust_vat_reg_no() {
		return cust_vat_reg_no;
	}
	public void setCust_vat_reg_no(String cust_vat_reg_no) {
		this.cust_vat_reg_no = cust_vat_reg_no;
	}
	public String getCust_tin() {
		return cust_tin;
	}
	public void setCust_tin(String cust_tin) {
		this.cust_tin = cust_tin;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getCheque_no() {
		return cheque_no;
	}
	public void setCheque_no(String cheque_no) {
		this.cheque_no = cheque_no;
	}
	public int getMonth_id() {
		return month_id;
	}
	public void setMonth_id(int month_id) {
		this.month_id = month_id;
	}
	public int getAc_year() {
		return ac_year;
	}
	public void setAc_year(int ac_year) {
		this.ac_year = ac_year;
	}
	public int getSm_id() {
		return sm_id;
	}
	public void setSm_id(int sm_id) {
		this.sm_id = sm_id;
	}
	public String getReg_fee() {
		return reg_fee;
	}
	public void setReg_fee(String reg_fee) {
		this.reg_fee = reg_fee;
	}
	public String getPaystud_status() {
		return paystud_status;
	}
	public void setPaystud_status(String paystud_status) {
		this.paystud_status = paystud_status;
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
}
