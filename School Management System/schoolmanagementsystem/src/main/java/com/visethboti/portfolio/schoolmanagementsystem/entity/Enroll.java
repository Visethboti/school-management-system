package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Enroll")
@IdClass(EnrollID.class)
public class Enroll {
	// define fields
	@Id
	@Column(name="studentID")
	private int studentID;
	
	@Id
	@Column(name="sectionID")
	private int sectionID;
	
	@Column(name="enrollDate")
	private String enrollDate;
	
	@Column(name="enrollGrade")
	private char enrollGrade;
	
	// constructors
	
	public Enroll() {
	}

	public Enroll(int studentID, int sectionID, String enrollDate, char enrollGrade) {
		super();
		this.studentID = studentID;
		this.sectionID = sectionID;
		this.enrollDate = enrollDate;
		this.enrollGrade = enrollGrade;
	}


	// getter and setter
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getEnrollGrade() {
		return enrollGrade;
	}

	public void setEnrollGrade(char enrollGrade) {
		this.enrollGrade = enrollGrade;
	}

	// toString

	@Override
	public String toString() {
		return "Enroll [studentID=" + studentID + ", sectionID=" + sectionID + ", enrollDate=" + enrollDate
				+ ", enrollGrade=" + enrollGrade + "]";
	}
	
}
