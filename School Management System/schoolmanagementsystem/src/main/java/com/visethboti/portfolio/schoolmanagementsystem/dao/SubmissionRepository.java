package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
	public List<Submission> findAllByAssignmentIDAndStudentID(int AssignmentID, int StudentID);
	public List<Submission> findAllByAssignmentID(int theAssignmentID);
	
	public void deleteAllByStudentIDEquals(int theStudentID);
	
	@Query(nativeQuery=true, value="select Enroll.studentID from Enroll, Section, Assignment where Enroll.sectionID = Section.sectionID and Section.sectionID = Assignment.sectionID and Assignment.assignmentID = ?1")
	public List<Integer> getAllStudentIDHaveAssignment(int theAssignmentID);
}
