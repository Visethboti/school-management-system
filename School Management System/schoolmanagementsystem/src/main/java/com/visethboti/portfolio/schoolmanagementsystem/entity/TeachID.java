package com.visethboti.portfolio.schoolmanagementsystem.entity;

import java.io.Serializable;

public class TeachID implements Serializable {

	private int facultyID;
	
	private int sectionID;
	// constructors
	
	public TeachID() {
		
	}
	
	public TeachID(int facultyID, int sectionID) {
		this.facultyID = facultyID;
		this.sectionID = sectionID;
	}

	
	// getter and setter

	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
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
		return "TeachID [facultyID=" + facultyID + ", sectionID=" + sectionID + "]";
	}
	
}
