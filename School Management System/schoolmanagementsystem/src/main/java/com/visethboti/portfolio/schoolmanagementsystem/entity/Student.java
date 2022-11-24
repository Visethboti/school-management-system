package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	// define fields
	@Id
	@Column(name="studentID")
	private int studentID;
	
	// define constructors
	
	public Student() {
		
	}

	public Student(int studentID) {
		super();
		this.studentID = studentID;
	}

	public int getstudentID() {
		return studentID;
	}

	public void setstudentID(int studentID) {
		this.studentID = studentID;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + "]";
	}
	
		
}
