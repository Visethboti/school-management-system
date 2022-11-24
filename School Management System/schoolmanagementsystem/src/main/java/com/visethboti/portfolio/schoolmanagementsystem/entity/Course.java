package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	// define fields
	@Id
	@Column(name="courseID")
	private int adminID;
	
	@Column(name="courseName")
	private String courseName;
	
	@Column(name="courseCredit")
	private int courseCredit;
	
	@Column(name="courseDecription")
	private String courseDescription;

	// constructors
	
	public Course() {
	}
	
	public Course(int adminID, String courseName, int courseCredit, String courseDescription) {
		this.adminID = adminID;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseDescription = courseDescription;
	}

	// getter and setter
	
	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	// toString
	
	@Override
	public String toString() {
		return "Course [adminID=" + adminID + ", courseName=" + courseName + ", courseCredit=" + courseCredit
				+ ", courseDescription=" + courseDescription + "]";
	}
}
