package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.UserRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		this.userRepository = theUserRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int theUserID) {
		Optional<User> result = userRepository.findById(theUserID);
		
		User theUser = null;
		
		if(result.isPresent()) {
			theUser = result.get();
		} else {
			// didnt find the user
			throw new RuntimeException("Did not find user id - " + theUserID);
		}
		
		return theUser;
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theUserID) {
		userRepository.deleteById(theUserID);
	}

}
