package com.visethboti.portfolio.schoolmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
}
