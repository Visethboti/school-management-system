package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Enroll;

public interface EnrollRepository extends JpaRepository<Enroll, Integer> {
	public Enroll findBySectionIDAndStudentID(int theSectionID,int theStudentID);
	public List<Enroll> findAllBySectionIDEquals(int theSectionID);
	public List<Enroll> findAllByStudentIDEquals(int theStudentID);
	
	@Transactional
	public void deleteBySectionIDAndStudentID(int theSectionID,int theStudentID);
	
	public void deleteAllByStudentID(int theStudentID);
	
	public void deleteAllBySectionID(int theSectionID);
	
	@Query(nativeQuery=true, value="select count(Enroll.studentID) from Enroll where Enroll.sectionID = ?1")
	public int getNumberofStudentsEnrolledInSection(int theSectionID);
	
	@Query(nativeQuery=true, value="select * from Enroll where Enroll.sectionID = ?1 order by Enroll.studentID limit ?2,10")
	public List<Enroll> findAllByCourseIDBatchOfTen(int sectionID, int studentIndex);
	
	@Query(nativeQuery=true, value="select * from Enroll where Enroll.sectionID = ?1 and Enroll.studentID like ?3 order by Enroll.enrollDate limit ?2,10")
	public List<Enroll> findAllByCourseIDBatchOfTenAndSearch(int sectionID, int studentIndex, String studentSearch);
}
