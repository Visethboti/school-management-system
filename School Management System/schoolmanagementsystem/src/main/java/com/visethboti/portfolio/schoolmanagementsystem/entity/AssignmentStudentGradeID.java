package com.visethboti.portfolio.schoolmanagementsystem.entity;

import java.io.Serializable;

public class AssignmentStudentGradeID implements Serializable {

	private int assignmentID;
	
	private int studentID;
	// constructors
	
	public AssignmentStudentGradeID() {
		
	}

	public AssignmentStudentGradeID(int assignmentID, int studentID) {
		super();
		this.assignmentID = assignmentID;
		this.studentID = studentID;
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

	// toString

	@Override
	public String toString() {
		return "AssignmentStudentGradeID [assignmentID=" + assignmentID + ", studentID=" + studentID + "]";
	}
	
}
