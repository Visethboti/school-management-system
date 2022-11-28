package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.AssignmentStudentGrade;

public interface AssignmentStudentGradeService {
	public List<AssignmentStudentGrade> findAll();
	public AssignmentStudentGrade findById(int theAssignmentStudentGradeID);
	public void save(AssignmentStudentGrade theAssignmentStudentGrade);
	public void deleteById(int theAssignmentStudentGradeID);
}
