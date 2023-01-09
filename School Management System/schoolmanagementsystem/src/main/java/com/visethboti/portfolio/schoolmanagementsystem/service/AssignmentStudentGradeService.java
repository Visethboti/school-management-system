package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Assignment;
import com.visethboti.portfolio.schoolmanagementsystem.entity.AssignmentStudentGrade;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Enroll;

public interface AssignmentStudentGradeService {
	public List<AssignmentStudentGrade> findAll();
	public AssignmentStudentGrade findById(int theAssignmentStudentGradeID);
	public void save(AssignmentStudentGrade theAssignmentStudentGrade);
	public void deleteById(int theAssignmentStudentGradeID);
	
	public void createAssignmentStudentGradeForNewAssignment(Assignment theAssignment);
	public void createAssignmentStudentGradesForNewStudentEnroll(Enroll enroll);
	
	public List<AssignmentStudentGrade> findAllByAssignmentID(int assigmentID);
}
