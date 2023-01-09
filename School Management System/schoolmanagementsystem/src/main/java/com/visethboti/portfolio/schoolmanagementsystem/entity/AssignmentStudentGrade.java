package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="AssignmentStudentGrade")
@IdClass(AssignmentStudentGradeID.class)
public class AssignmentStudentGrade {
	// define fields
	@Id
	@Column(name="assignmentID")
	private int assignmentID;
	
	@Id
	@Column(name="studentID")
	private int studentID;
	
	@Column(name="assignmentStudentGrade")
	private int assignmentStudentGrade;

	// constructors
	
	public AssignmentStudentGrade() {
	}

	public AssignmentStudentGrade(int assignmentID, int studentID, int assignmentStudentGrade) {
		super();
		this.assignmentID = assignmentID;
		this.studentID = studentID;
		this.assignmentStudentGrade = assignmentStudentGrade;
	}

	// getter and setter
	
	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getAssignmentStudentGrade() {
		return assignmentStudentGrade;
	}

	public void setAssignmentStudentGrade(int assignmentStudentGrade) {
		this.assignmentStudentGrade = assignmentStudentGrade;
	}

	// toString

	@Override
	public String toString() {
		return "AssignmentStudentGrade [assignmentID=" + assignmentID + ", studentID=" + studentID
				+ ", assignmentStudentGrade=" + assignmentStudentGrade + "]";
	}
	
}
