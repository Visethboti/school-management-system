package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.UserRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		this.userRepository = theUserRepository;
	}
	
	@PostConstruct
	private void addRootUser() {
		Optional<User> result = userRepository.findById(1);
		
		if(result.isPresent()) {
			
		}else {
			String password = "12345";
			password = passwordEncoder.encode(password);
			User theUser = new User(1, password, "Admin", "User", "admin address", 20, 'M', 1, "ROLE_ADMIN");
			userRepository.save(theUser);
		}
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
		//encode the password
		String password = theUser.getPassword(); 
		password = passwordEncoder.encode(password);
		theUser.setPassword(password);

		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theUserID) {
		userRepository.deleteById(theUserID);
	}

}
