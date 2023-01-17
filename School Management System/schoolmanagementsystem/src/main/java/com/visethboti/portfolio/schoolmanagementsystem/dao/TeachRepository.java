package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Teach;

public interface TeachRepository extends JpaRepository<Teach, Integer> {
	public Teach findBySectionIDAndFacultyID(int theSectionID,int theFacultyID);
	public List<Teach> findAllBySectionIDEquals(int theSectionID);
	public List<Teach> findAllByFacultyIDEquals(int theFacultyID);
	
	@Transactional
	public void deleteBySectionIDAndFacultyID(int theSectionID,int theFacultyID);
	
	public void deleteAllByFacultyIDEquals(int theFacultyID);
	
	public void deleteAllBySectionIDEquals(int theSectionID);
	
	@Query(nativeQuery=true, value="select * from Teach where Teach.sectionID = ?1 order by Teach.facultyID limit ?2,10")
	public List<Teach> findAllByCourseIDBatchOfTen(int sectionID, int facultyIndex);
	
	@Query(nativeQuery=true, value="select * from Teach where Teach.sectionID = ?1 and Teach.facultyID like ?3 order by Teach.assignedDate limit ?2,10")
	public List<Teach> findAllByCourseIDBatchOfTenAndSearch(int sectionID, int facultyIndex, String searchKey);
}
