package com.fidel.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="exam_result")
public class ExamResult {
	
	@Id
	@GeneratedValue
	private int er_id;
	private int si_id;
	private int examsub_id;
	private double result;
	private int at_id;
	@Column(name="fical_year")
	private int fiscal_year;
	@Column(name="crt_by")
	private int create_by;
	@Column(name="crt_date")
	private Date create_date;
	@Column(name="udt_by")
	private int update_by;
	@Column(name="udt_date")
	private Date update_date;
	
	@Transient
	private double average_result;
	@Transient
	private int stud_rank;
	@Transient
	private String studentResultStatus;
	@Transient
	private Double quarter_one_total;
	@Transient
	private Double quarter_two_total;
	@Transient
	private Double quarter_three_total;
	@Transient
	private Double quarter_four_total;
	@Transient
	private Double average_quarter_mark;
	@Transient
	private Double total_mark;
	@Transient
	private int student_rank;
	@Transient
	private Double quarter_total;
	
	@Transient
	private ExamSubjectRelation examSubjectRel;
	@Transient
	private StudentRegistration studentRegistration;
	@Transient
	private StudentInformation studentInformation;
	
	
	public int getEr_id() {
		return er_id;
	}
	public void setEr_id(int er_id) {
		this.er_id = er_id;
	}
	public int getSi_id() {
		return si_id;
	}
	public void setSi_id(int si_id) {
		this.si_id = si_id;
	}
	public int getExamsub_id() {
		return examsub_id;
	}
	public void setExamsub_id(int examsub_id) {
		this.examsub_id = examsub_id;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public int getAt_id() {
		return at_id;
	}
	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}
	public int getFiscal_year() {
		return fiscal_year;
	}
	public void setFiscal_year(int fiscal_year) {
		this.fiscal_year = fiscal_year;
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
	public ExamSubjectRelation getExamSubjectRel() {
		return examSubjectRel;
	}
	public void setExamSubjectRel(ExamSubjectRelation examSubjectRel) {
		this.examSubjectRel = examSubjectRel;
	}
	public StudentRegistration getStudentRegistration() {
		return studentRegistration;
	}
	public void setStudentRegistration(StudentRegistration studentRegistration) {
		this.studentRegistration = studentRegistration;
	}
	public StudentInformation getStudentInformation() {
		return studentInformation;
	}
	public void setStudentInformation(StudentInformation studentInformation) {
		this.studentInformation = studentInformation;
	}
	public double getAverage_result() {
		return average_result;
	}
	public void setAverage_result(double average_result) {
		this.average_result = average_result;
	}
	public int getStud_rank() {
		return stud_rank;
	}
	public void setStud_rank(int stud_rank) {
		this.stud_rank = stud_rank;
	}
	public String getStudentResultStatus() {
		return studentResultStatus;
	}
	public void setStudentResultStatus(String studentResultStatus) {
		this.studentResultStatus = studentResultStatus;
	}
	public Double getQuarter_one_total() {
		return quarter_one_total;
	}
	public void setQuarter_one_total(Double quarter_one_total) {
		this.quarter_one_total = quarter_one_total;
	}
	public Double getQuarter_two_total() {
		return quarter_two_total;
	}
	public void setQuarter_two_total(Double quarter_two_total) {
		this.quarter_two_total = quarter_two_total;
	}
	public Double getQuarter_three_total() {
		return quarter_three_total;
	}
	public void setQuarter_three_total(Double quarter_three_total) {
		this.quarter_three_total = quarter_three_total;
	}
	public Double getQuarter_four_total() {
		return quarter_four_total;
	}
	public void setQuarter_four_total(Double quarter_four_total) {
		this.quarter_four_total = quarter_four_total;
	}
	public Double getAverage_quarter_mark() {
		return average_quarter_mark;
	}
	public void setAverage_quarter_mark(Double average_quarter_mark) {
		this.average_quarter_mark = average_quarter_mark;
	}
	public Double getTotal_mark() {
		return total_mark;
	}
	public void setTotal_mark(Double total_mark) {
		this.total_mark = total_mark;
	}
	public int getStudent_rank() {
		return student_rank;
	}
	public void setStudent_rank(int student_rank) {
		this.student_rank = student_rank;
	}
	public Double getQuarter_total() {
		return quarter_total;
	}
	public void setQuarter_total(Double quarter_total) {
		this.quarter_total = quarter_total;
	}
}
