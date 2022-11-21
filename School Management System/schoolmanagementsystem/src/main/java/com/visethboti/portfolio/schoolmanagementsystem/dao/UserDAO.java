package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

public interface UserDAO {
	public List<User> findAll();
	public User findById(int theUserID);
	public void save(User theUser);
	public void deleteById(int theUserID);
}
