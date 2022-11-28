package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
	public List<Submission> findAllByAssignmentIDAndStudentID(int theAssignmentID, int theStudentID);
	public List<Submission> findAllByAssignmentID(int theAssignmentID);
	
	public void deleteAllByStudentIDEquals(int theStudentID);
}
