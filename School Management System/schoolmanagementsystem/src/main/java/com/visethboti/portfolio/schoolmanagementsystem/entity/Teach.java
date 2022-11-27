package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Teach")
@IdClass(TeachID.class)
public class Teach {
	// define fields
	@Id
	@Column(name="facultyID")
	private int facultyID;
	
	@Id
	@Column(name="sectionID")
	private int sectionID;
	
	@Column(name="assignedDate")
	private String assignedDate;
	
	// constructors
	
	public Teach() {
	}

	public Teach(int facultyID, int sectionID, String assignedDate) {
		this.facultyID = facultyID;
		this.sectionID = sectionID;
		this.assignedDate = assignedDate;
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

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	// toString
	@Override
	public String toString() {
		return "Teach [facultyID=" + facultyID + ", sectionID=" + sectionID + ", assignedDate=" + assignedDate + "]";
	}
	
	
}
