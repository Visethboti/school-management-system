package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {
	public List<Section> findAllByCourseIDEquals(int theCourseID);
}
