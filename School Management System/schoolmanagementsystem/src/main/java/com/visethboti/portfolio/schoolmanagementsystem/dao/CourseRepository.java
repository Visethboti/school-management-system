package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query(nativeQuery=true, value="select * from Course order by Course.courseID limit ?1,10")
	public List<Course> findAllByBatchOfTen(int courseIndex);
	
	@Query(nativeQuery=true, value="select * from Course where Course.courseID = ?2 or Course.courseName like ?3 order by Course.courseID limit ?1,10")
	public List<Course> findAllByBatchOfTenAndSearch(int courseIndex, int searchID, String searchKey);
}
