package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findById(int theUserID);
	public void save(User theUser);
	public void deleteById(int theUserID);
}
