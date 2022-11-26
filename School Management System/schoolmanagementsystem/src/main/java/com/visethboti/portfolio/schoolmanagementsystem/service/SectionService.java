package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;

public interface SectionService {
	public List<Section> findAll();
	public Section findById(int theSectionID);
	public void save(Section theSection);
	public void deleteById(int theSectionID);
	public List<Section> findAllByCourseID(int theCourseID);
}
