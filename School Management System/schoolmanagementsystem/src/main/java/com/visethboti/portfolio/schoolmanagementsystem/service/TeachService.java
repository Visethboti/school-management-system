package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Teach;

public interface TeachService {
	public List<Teach> findAll();
	public Teach findById(int theSectionID, int theFacultyID);
	public void save(Teach theTeach);
	public void deleteById(int theSectionID, int theFacultyID);
	public List<Teach> findAllBySectionID(int theSectionID);
	public List<Teach> findAllByFacultyID(int theFacultyID);
	
	public void deleteAllBySectionID(int theSectionID);
	public void deleteAllByFacultyID(int theFacultyID);
}
