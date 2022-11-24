package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Faculty")
public class Faculty {
	// define fields
	@Id
	@Column(name="facultyID")
	private int facultyID;
	
	// define constructors
	
	public Faculty() {
		
	}

	public Faculty(int facultyID) {
		super();
		this.facultyID = facultyID;
	}

	public int getfacultyID() {
		return facultyID;
	}

	public void setfacultyID(int facultyID) {
		this.facultyID = facultyID;
	}

	@Override
	public String toString() {
		return "Faculty [facultyID=" + facultyID + "]";
	}
		
		
}
