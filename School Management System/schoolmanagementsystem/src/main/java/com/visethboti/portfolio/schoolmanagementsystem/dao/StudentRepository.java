package com.visethboti.portfolio.schoolmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
