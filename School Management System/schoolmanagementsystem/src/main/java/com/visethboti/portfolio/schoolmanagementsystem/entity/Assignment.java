package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Assignment")
public class Assignment {
	// define fields
	@Id
	@Column(name="assignmentID")
	private int assignmentID;
	
	@Column(name="sectionID")
	private int sectionID;
	
	@Column(name="assignmentName")
	private String assignmentName;
	
	@Column(name="assignmentDescription")
	private String assignmentDescription;
	
	@Column(name="assignmentGrade")
	private int assignmentGrade;

	// constructors
	
	public Assignment() {
	}

	public Assignment(int assignmentID, int sectionID, String assignmentName, String assignmentDescription,
			int assignmentGrade) {
		super();
		this.assignmentID = assignmentID;
		this.sectionID = sectionID;
		this.assignmentName = assignmentName;
		this.assignmentDescription = assignmentDescription;
		this.assignmentGrade = assignmentGrade;
	}
	
	// getter and setter

	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getAssignmentDescription() {
		return assignmentDescription;
	}

	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}
	
	public int getAssignmentGrade() {
		return assignmentGrade;
	}

	public void setAssignmentGrade(int assignmentGrade) {
		this.assignmentGrade = assignmentGrade;
	}

	
	// toString

	@Override
	public String toString() {
		return "Assignment [assignmentID=" + assignmentID + ", sectionID=" + sectionID + ", assignmentName="
				+ assignmentName + ", assignmentDescription=" + assignmentDescription + ", assignmentGrade="
				+ assignmentGrade + "]";
	}
}
