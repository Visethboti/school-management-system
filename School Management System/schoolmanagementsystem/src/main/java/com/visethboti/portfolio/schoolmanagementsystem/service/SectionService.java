package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;

public interface SectionService {
	public List<Section> findAll();
	public Section findById(int theSectionID);
	public void save(Section theSection);
	public void deleteById(int theSectionID);
	public List<Section> findAllByCourseID(int theCourseID);
	
	public void deleteAllByCourseID(int theCourseID);
	public List<Section> findSectionsByStudentIDEnroll(int theStudentID);
	public List<Section> findSectionsByFacultyIDTeach(int theFacultyID);
	
	public List<Section> findAllByCourseIDBatchOfTenAndSearch(int courseID, int sectionIndex, String searchKey);
	public List<Section> findAllByBatchOfTenAndSearch(int sectionIndex, String searchKey);
}
