package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Submission")
public class Submission {
	// define fields
	@Id
	@Column(name="submissionID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	private int submissionID;
	
	@Column(name="studentID")
	private int studentID;
	
	@Column(name="assignmentID")
	private int assignmentID;
	
	@Column(name="submissionText")
	private String submissionText;
	
	@Column(name="submissionGrade")
	private int submissionGrade;

	@Column(name="submissionDate")
	private String submissionDate;
	
	// constructors
	
	public Submission() {
	}

	public Submission(int submissionID, int studentID, int assignmentID, String submissionText, int submissionGrade,
			String submissionDate) {
		super();
		this.submissionID = submissionID;
		this.studentID = studentID;
		this.assignmentID = assignmentID;
		this.submissionText = submissionText;
		this.submissionGrade = submissionGrade;
		this.submissionDate = submissionDate;
	}
	
	// getter and setter

	public int getSubmissionID() {
		return submissionID;
	}

	public void setSubmissionID(int submissionID) {
		this.submissionID = submissionID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getSubmissionText() {
		return submissionText;
	}

	public void setSubmissionText(String submissionText) {
		this.submissionText = submissionText;
	}

	public int getSubmissionGrade() {
		return submissionGrade;
	}

	public void setSubmissionGrade(int submissionGrade) {
		this.submissionGrade = submissionGrade;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	// toString
	
	@Override
	public String toString() {
		return "Submission [submissionID=" + submissionID + ", studentID=" + studentID + ", assignmentID="
				+ assignmentID + ", submissionText=" + submissionText + ", submissionGrade=" + submissionGrade
				+ ", submissionDate=" + submissionDate + "]";
	}
}
