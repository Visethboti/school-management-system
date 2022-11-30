package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {
	public List<Section> findAllByCourseIDEquals(int theCourseID);
	
	@Query(nativeQuery=true, value="select * from Section where Section.sectionID in (select Teach.sectionID from Teach where Teach.facultyID = ?1)") // ?1 is the 1st parameter, theFacultyID
	public List<Section> findAllSectionsTeachByFacultyID(int theFacultyID);
	
	@Query(nativeQuery=true, value="select * from Section where Section.sectionID in (select Enroll.sectionID from Enroll where Enroll.studentID = ?1)") 
	public List<Section> findAllSectionsEnrollByStudentID(int theStudentID);
	
	public void deleteAllByCourseIDEquals(int theCourseID);
}
