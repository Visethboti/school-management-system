package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
	public List<Assignment> findAllBySectionID(int theSectionID);
}
