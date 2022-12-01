package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Submission;

public interface SubmissionService {
	public List<Submission> findAll();
	public Submission findById(int theSubmissionID);
	public void save(Submission theSubmission);
	public void deleteById(int theSubmissionID);
	
	public List<Submission> findAllByAssignmentIDAndStudentID(int assignmentID, int StudentID);
	public List<Submission> findAllByAssignmentID(int theAssignmentID);
	public List<List<Submission>> GetListofStudentSubmissions(int theAssignmentID);
	
	public void deleteAllByStudentID(int theStudentID);
}
