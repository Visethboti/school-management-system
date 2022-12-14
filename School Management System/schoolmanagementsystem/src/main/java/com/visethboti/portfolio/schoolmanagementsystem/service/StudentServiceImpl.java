package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.StudentRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	
	private StudentRepository studentRepository;

	
	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		this.studentRepository = theStudentRepository;
	}
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theStudentID) {
		Optional<Student> result = studentRepository.findById(theStudentID);
		
		Student theStudent = null;
		
		if(result.isPresent()) {
			theStudent = result.get();
		} else {
			// didnt find the student
			throw new RuntimeException("Did not find student id - " + theStudentID);
		}
		
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theStudentID) {
		studentRepository.deleteById(theStudentID);
	}

}
