package com.visethboti.portfolio.schoolmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
}
