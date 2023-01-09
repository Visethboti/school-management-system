package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visethboti.portfolio.schoolmanagementsystem.entity.AssignmentStudentGrade;

public interface AssignmentStudentGradeRepository extends JpaRepository<AssignmentStudentGrade, Integer> {
	
	@Query(nativeQuery=true, value="select * from AssignmentStudentGrade where AssignmentStudentGrade.assignmentID = ?1")
	public List<AssignmentStudentGrade> findAllByAssignmentID(int assigmentID);
}
