package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
