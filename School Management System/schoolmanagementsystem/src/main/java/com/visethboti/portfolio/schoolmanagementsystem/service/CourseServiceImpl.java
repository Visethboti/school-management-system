package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.CourseRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	
	private CourseRepository courseRepository;
	
	private SectionService sectionService;
	
	@Autowired
	public CourseServiceImpl(CourseRepository theCourseRepository,
			SectionService sectionService) {
		this.courseRepository = theCourseRepository;
		this.sectionService = sectionService;
	}
	
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(int theCourseID) {
		Optional<Course> result = courseRepository.findById(theCourseID);
		
		Course theCourse = null;
		
		if(result.isPresent()) {
			theCourse = result.get();
		} else {
			// didnt find the course
			throw new RuntimeException("Did not find course id - " + theCourseID);
		}
		
		return theCourse;
	}

	@Override
	public void save(Course theCourse) {
		courseRepository.save(theCourse);
	}

	@Override
	public void deleteById(int theCourseID) {
		courseRepository.deleteById(theCourseID);
		
		sectionService.deleteAllByCourseIDEquals(theCourseID);
	}

}
