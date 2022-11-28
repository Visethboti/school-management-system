package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.AssignmentRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.EnrollRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.SubmissionRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Assignment;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Enroll;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Submission;

@Service
public class SubmissionServiceImpl implements SubmissionService {

	private SubmissionRepository submissionRepository;
	private EnrollRepository enrollRepository;
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	public SubmissionServiceImpl(SubmissionRepository submissionRepository, EnrollRepository enrollRepository, AssignmentRepository assignmentRepository) {
		this.submissionRepository = submissionRepository;
		this.enrollRepository = enrollRepository;
		this.assignmentRepository = assignmentRepository;
	}
	
	@Override
	public List<Submission> findAll() {
		return submissionRepository.findAll();
	}

	@Override
	public Submission findById(int theSubmissionID) {
		Optional<Submission> result = submissionRepository.findById(theSubmissionID);
		
		Submission submission = null;
		
		if(result.isPresent()) {
			submission = result.get();
		} else {
			// didnt find the student
			throw new RuntimeException("Did not find student id - " + theSubmissionID);
		}
		
		return submission;
	}

	@Override
	public void save(Submission theSubmission) {
		submissionRepository.save(theSubmission);
	}

	@Override
	public void deleteById(int theSubmissionID) {
		submissionRepository.deleteById(theSubmissionID);
	}

	@Override
	public List<Submission> findAllByAssignmentIDAndStudentID(int theAssignmentID, int theStudentID) {
		return submissionRepository.findAllByAssignmentIDAndStudentID(theAssignmentID, theStudentID);
	}

	@Override
	public List<Submission> findAllByAssignmentID(int theAssignmentID) {
		return submissionRepository.findAllByAssignmentID(theAssignmentID);
	}
	
	@Override
	public List<List<Submission>> GetListofStudentSubmissions(int theAssignmentID) {
		Optional<Assignment> result = assignmentRepository.findById(theAssignmentID);
		
		Assignment assignment = null;
		
		if(result.isPresent()) {
			assignment = result.get();
		} else {
			// didnt find the assignment
			throw new RuntimeException("Did not find student id - " + theAssignmentID);
		}
		
		// Seperate into list for each student
		List<List<Submission>> listOfStudentSubmission = new ArrayList<List<Submission>>();
		List<Enroll> listOfEnrolls = enrollRepository.findAllBySectionIDEquals(assignment.getSectionID());
		
		ListIterator<Enroll> listOfEnrollsIterator = listOfEnrolls.listIterator();
		while(listOfEnrollsIterator.hasNext()) {
			Enroll enroll = listOfEnrollsIterator.next();
			listOfStudentSubmission.add(submissionRepository.findAllByAssignmentIDAndStudentID(theAssignmentID, enroll.getStudentID()));
		}
		
		return listOfStudentSubmission;
	}
}
