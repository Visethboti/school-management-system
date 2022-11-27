package com.visethboti.portfolio.schoolmanagementsystem.entity;

import java.io.Serializable;

public class EnrollID implements Serializable {

	private int studentID;
	
	private int sectionID;
	// constructors
	
	public EnrollID() {
		
	}
	
	public EnrollID(int studentID, int sectionID) {
		super();
		this.studentID = studentID;
		this.sectionID = sectionID;
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

	// toString

	@Override
	public String toString() {
		return "EnrollID [studentID=" + studentID + ", sectionID=" + sectionID + "]";
	}
	
}
