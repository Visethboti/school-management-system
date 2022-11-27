package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Assignment;

public interface AssignmentService {
	public List<Assignment> findAll();
	public Assignment findById(int theAssignmentID);
	public void save(Assignment theAssignment);
	public void deleteById(int theAssignmentID);
	
	public List<Assignment> findAllBySectionID(int theSectionID);
}
