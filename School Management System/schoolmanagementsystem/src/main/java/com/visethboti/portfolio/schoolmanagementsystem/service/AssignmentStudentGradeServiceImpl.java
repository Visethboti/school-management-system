package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.AssignmentRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.AssignmentStudentGradeRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.EnrollRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Assignment;
import com.visethboti.portfolio.schoolmanagementsystem.entity.AssignmentStudentGrade;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Enroll;

@Service
public class AssignmentStudentGradeServiceImpl implements AssignmentStudentGradeService {

	
	private AssignmentStudentGradeRepository assignmentStudentGradeRepository;
	private EnrollRepository enrollRepository;
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	public AssignmentStudentGradeServiceImpl(AssignmentStudentGradeRepository theAssignmentStudentGradeRepository,
			EnrollRepository enrollRepository, AssignmentRepository assignmentRepository) {
		this.assignmentStudentGradeRepository = theAssignmentStudentGradeRepository;
		this.enrollRepository = enrollRepository;
		this.assignmentRepository = assignmentRepository;
	}
	
	@Override
	public List<AssignmentStudentGrade> findAll() {
		return assignmentStudentGradeRepository.findAll();
	}

	@Override
	public AssignmentStudentGrade findById(int theAssignmentStudentGradeID) {
		Optional<AssignmentStudentGrade> result = assignmentStudentGradeRepository.findById(theAssignmentStudentGradeID);
		
		AssignmentStudentGrade theAssignmentStudentGrade = null;
		
		if(result.isPresent()) {
			theAssignmentStudentGrade = result.get();
		} else {
			// didnt find the assignment
			throw new RuntimeException("Did not find assignment id - " + theAssignmentStudentGradeID);
		}
		
		return theAssignmentStudentGrade;
	}

	@Override
	public void save(AssignmentStudentGrade theAssignmentStudentGrade) {
		assignmentStudentGradeRepository.save(theAssignmentStudentGrade);
	}

	@Override
	public void deleteById(int theAssignmentStudentGradeID) {
		assignmentStudentGradeRepository.deleteById(theAssignmentStudentGradeID);
	}
	
	@Override
	public void createAssignmentStudentGradeForNewAssignment(Assignment theAssignment) {
		List<Enroll> listEnroll = enrollRepository.findAllBySectionIDEquals(theAssignment.getSectionID());
		
		// For each student enroll, create a new assignmentStudentGrade for that student for this assignment
		for(int i = 0; i < listEnroll.size(); i++) {
			AssignmentStudentGrade newAssignmentStudentGrade = new AssignmentStudentGrade();
			newAssignmentStudentGrade.setAssignmentID(theAssignment.getAssignmentID());
			newAssignmentStudentGrade.setStudentID(listEnroll.get(i).getStudentID());
			newAssignmentStudentGrade.setAssignmentStudentGrade(0);
		}
		
	}
	
	@Override
	public void createAssignmentStudentGradesForNewStudentEnroll(Enroll enroll) {
		List<Assignment> listAssignment = assignmentRepository.findAllBySectionID(enroll.getSectionID());
		
		// For each assignment in this section, create a new assignmentStudentGrade for this student that just enrolled
		for(int i = 0; i < listAssignment.size(); i++) {
			AssignmentStudentGrade newAssignmentStudentGrade = new AssignmentStudentGrade();
			newAssignmentStudentGrade.setAssignmentID(listAssignment.get(i).getAssignmentID());
			newAssignmentStudentGrade.setStudentID(enroll.getStudentID());
			newAssignmentStudentGrade.setAssignmentStudentGrade(0);
		}
	}
}
