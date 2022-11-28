package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.AssignmentStudentGradeRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.AssignmentStudentGrade;

@Service
public class AssignmentStudentGradeServiceImpl implements AssignmentStudentGradeService {

	
	private AssignmentStudentGradeRepository assignmentRepository;
	
	@Autowired
	public AssignmentStudentGradeServiceImpl(AssignmentStudentGradeRepository theAssignmentStudentGradeRepository) {
		this.assignmentRepository = theAssignmentStudentGradeRepository;
	}
	
	@Override
	public List<AssignmentStudentGrade> findAll() {
		return assignmentRepository.findAll();
	}

	@Override
	public AssignmentStudentGrade findById(int theAssignmentStudentGradeID) {
		Optional<AssignmentStudentGrade> result = assignmentRepository.findById(theAssignmentStudentGradeID);
		
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
		assignmentRepository.save(theAssignmentStudentGrade);
	}

	@Override
	public void deleteById(int theAssignmentStudentGradeID) {
		assignmentRepository.deleteById(theAssignmentStudentGradeID);
	}
}
