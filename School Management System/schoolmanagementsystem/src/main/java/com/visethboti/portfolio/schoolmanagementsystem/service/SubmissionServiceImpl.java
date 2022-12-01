package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.SubmissionRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Submission;

@Service
public class SubmissionServiceImpl implements SubmissionService {

	private SubmissionRepository submissionRepository;
	
	@Autowired
	public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
		this.submissionRepository = submissionRepository;
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
		// Seperate into list for each student
		List<List<Submission>> listOfStudentSubmission = new ArrayList<List<Submission>>();
		List<Integer> studentIDListHaveAssingment = submissionRepository.getAllStudentIDHaveAssignment(theAssignmentID);
	
		ListIterator<Integer> studentIDIterator = studentIDListHaveAssingment.listIterator();
		while(studentIDIterator.hasNext()) {
			listOfStudentSubmission.add(submissionRepository.findAllByAssignmentIDAndStudentID(theAssignmentID, studentIDIterator.next()));
		}
		
		return listOfStudentSubmission;
	}
	
	@Override
	public void deleteAllByStudentID(int theStudentID) {
		submissionRepository.deleteAllByStudentIDEquals(theStudentID);
	}
}
