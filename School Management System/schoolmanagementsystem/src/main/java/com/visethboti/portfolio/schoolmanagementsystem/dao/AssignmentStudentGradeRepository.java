package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visethboti.portfolio.schoolmanagementsystem.entity.AssignmentStudentGrade;

public interface AssignmentStudentGradeRepository extends JpaRepository<AssignmentStudentGrade, Integer> {
	
	@Query(nativeQuery=true, value="select * from AssignmentStudentGrade where AssignmentStudentGrade.assignmentID = ?1 order by AssignmentStudentGrade.studentID")
	public List<AssignmentStudentGrade> findAllByAssignmentID(int assigmentID);
	
	@Query(nativeQuery=true, value="select * from AssignmentStudentGrade where AssignmentStudentGrade.assignmentID = ?1 and AssignmentStudentGrade.studentID = ?2")
	public AssignmentStudentGrade findByAssignmentIDAndStudentID(int assignmentID, int studentID);
	
	@Query(nativeQuery=true, value="select * from AssignmentStudentGrade where AssignmentStudentGrade.studentID = ?2 and AssignmentStudentGrade.assignmentID in (select Assignment.assignmentID from Assignment where Assignment.sectionID = ?1)")
	public List<AssignmentStudentGrade> findAllBySectionIDAndStudentID(int sectionID, int studentID);
}
