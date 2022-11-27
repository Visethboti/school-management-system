package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Teach;

public interface TeachRepository extends JpaRepository<Teach, Integer> {
	public Teach findBySectionIDAndFacultyID(int theSectionID,int theFacultyID);
	public List<Teach> findAllBySectionIDEquals(int theSectionID);
	public List<Teach> findAllByFacultyIDEquals(int theFacultyID);
	
	@Transactional
	public void deleteBySectionIDAndFacultyID(int theSectionID,int theFacultyID);
	
	public void deleteAllByFacultyID(int theFacultyID);
	
	public void deleteAllBySectionID(int theSectionID);
	
	
	
}
