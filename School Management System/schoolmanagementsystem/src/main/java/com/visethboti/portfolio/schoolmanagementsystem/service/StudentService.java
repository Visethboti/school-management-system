package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Student;

public interface StudentService {
	public List<Student> findAll();
	public Student findById(int theStudentID);
	public void save(Student theStudent);
	public void deleteById(int theStudentID);
}
