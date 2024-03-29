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
	
	@Autowired
	public CourseServiceImpl(CourseRepository theCourseRepository) {
		this.courseRepository = theCourseRepository;
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
	}

	@Override
	public List<Course> findAllByBatchOfTenAndSearch(int courseIndex, String searchKey) {
		if(searchKey.isEmpty())
			return courseRepository.findAllByBatchOfTen(courseIndex);
		else {
			if(searchKey.matches("[0-9.]+")) {
				return courseRepository.findAllByBatchOfTenAndSearch(courseIndex, Integer.valueOf(searchKey), "%" + searchKey + "%");
			}
			else {
				searchKey = "%" + searchKey + "%";
				return courseRepository.findAllByBatchOfTenAndSearch(courseIndex, 0 , searchKey);
			}
		}	
	}
}
