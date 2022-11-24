package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Course;

public interface CourseService {
	public List<Course> findAll();
	public Course findById(int theCourseID);
	public void save(Course theCourse);
	public void deleteById(int theCourseID);
}
