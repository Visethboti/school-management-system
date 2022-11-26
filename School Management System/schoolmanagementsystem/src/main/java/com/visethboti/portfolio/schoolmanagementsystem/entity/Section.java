package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Section")
public class Section {
	// define fields
	@Id
	@Column(name="sectionID")
	private int sectionID;
	
	@Column(name="courseID")
	private int courseID;
	
	@Column(name="academicYear")
	private String academicYear;
	
	// constructors
	
	public Section() {
	}

	public Section(int sectionID, int courseID, String academicYear) {
		super();
		this.sectionID = sectionID;
		this.courseID = courseID;
		this.academicYear = academicYear;
	}

	// getter and setter
	public int getSectionID() {
		return sectionID;
	}


	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}


	public String getAcademicYear() {
		return academicYear;
	}


	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	// toString
	
	

	@Override
	public String toString() {
		return "Section [sectionID=" + sectionID + ", courseID=" + courseID + ", academicYear=" + academicYear + "]";
	}
	
}
