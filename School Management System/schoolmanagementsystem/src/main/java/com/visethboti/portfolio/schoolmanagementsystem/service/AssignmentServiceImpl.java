package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.AssignmentRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Assignment;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	public AssignmentServiceImpl(AssignmentRepository theAssignmentRepository) {
		this.assignmentRepository = theAssignmentRepository;
	}
	
	@Override
	public List<Assignment> findAll() {
		return assignmentRepository.findAll();
	}

	@Override
	public Assignment findById(int theAssignmentID) {
		Optional<Assignment> result = assignmentRepository.findById(theAssignmentID);
		
		Assignment theAssignment = null;
		
		if(result.isPresent()) {
			theAssignment = result.get();
		} else {
			// didnt find the assignment
			throw new RuntimeException("Did not find assignment id - " + theAssignmentID);
		}
		
		return theAssignment;
	}

	@Override
	public void save(Assignment theAssignment) {
		assignmentRepository.save(theAssignment);
	}

	@Override
	public void deleteById(int theAssignmentID) {
		assignmentRepository.deleteById(theAssignmentID);
	}

	@Override
	public List<Assignment> findAllBySectionID(int theSectionID){
		return assignmentRepository.findAllBySectionID(theSectionID);
	}
}
