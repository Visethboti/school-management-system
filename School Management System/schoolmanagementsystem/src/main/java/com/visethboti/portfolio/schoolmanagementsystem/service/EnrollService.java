package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Enroll;

public interface EnrollService {
	public List<Enroll> findAll();
	public Enroll findById(int theSectionID, int theStudentID);
	public void save(Enroll theEnroll);
	public void deleteById(int theSectionID, int theStudentID);
	public List<Enroll> findAllBySectionID(int theSectionID);
	public List<Enroll> findAllByStudentID(int theStudentID);
	
	public void deleteAllBySectionID(int theSectionID);
	public void deleteAllByStudentID(int theStudentID);
	
	public List<Enroll> findAllBySectionIDBatchOfTenAndSearch(int sectionID, int studentIndex, String studentSearch);
}
