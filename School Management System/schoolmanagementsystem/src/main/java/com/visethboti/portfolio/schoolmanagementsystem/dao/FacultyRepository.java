package com.visethboti.portfolio.schoolmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	
}
