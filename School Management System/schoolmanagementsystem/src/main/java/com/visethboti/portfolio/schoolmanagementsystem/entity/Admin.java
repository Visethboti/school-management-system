package com.visethboti.portfolio.schoolmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin{
	// define fields
	@Id
	@Column(name="adminID")
	private int adminID;
	
	// define constructors
	
	public Admin() {
		
	}

	public Admin(int adminID) {
		super();
		this.adminID = adminID;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + "]";
	}
	
		
}
