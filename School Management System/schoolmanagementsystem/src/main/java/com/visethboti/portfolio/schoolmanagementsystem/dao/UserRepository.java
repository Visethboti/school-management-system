package com.visethboti.portfolio.schoolmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
