package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visethboti.portfolio.schoolmanagementsystem.dao.UserDAO;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;


@Service
public class UserServiceImplOld implements UserService {

	private UserDAO UserDAO;
	
	@Autowired
	public UserServiceImplOld(UserDAO theUserDAO) {
		this.UserDAO = theUserDAO;
	}
	
	@Override
	@Transactional
	public List<User> findAll() {
		return UserDAO.findAll();
	}

	@Override
	@Transactional
	public User findById(int theUserID) {
		return UserDAO.findById(theUserID);
	}

	@Override
	@Transactional
	public void save(User theUser) {
		UserDAO.save(theUser);
	}

	@Override
	@Transactional
	public void deleteById(int theUserID) {
		UserDAO.deleteById(theUserID);
	}

}
