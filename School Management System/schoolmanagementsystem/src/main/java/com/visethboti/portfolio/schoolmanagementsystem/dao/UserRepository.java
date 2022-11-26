package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByRoleEquals(String role);
}
