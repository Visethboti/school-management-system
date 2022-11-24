package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Faculty;

public interface FacultyService {
	public List<Faculty> findAll();
	public Faculty findById(int theFacultyID);
	public void save(Faculty theFaculty);
	public void deleteById(int theFacultyID);
}
