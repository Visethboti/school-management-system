package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.AdminRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.FacultyRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.StudentRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.UserRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Admin;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Faculty;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Student;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private StudentRepository studentRepository;
	private FacultyRepository facultyRepository;
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository, 
			StudentRepository theStudentRepository, 
			FacultyRepository theFacultyRepository, 
			AdminRepository theAdminRepository) {
		
		this.userRepository = theUserRepository;
		this.adminRepository = theAdminRepository;
		this.studentRepository = theStudentRepository;
		this.facultyRepository = theFacultyRepository;
	}
	
	@PostConstruct
	private void addRootUser() {
		/*
		Optional<User> result = userRepository.findById(1);
		
		if(result.isPresent()) {
			
		}else {
			String password = "12345";
			password = passwordEncoder.encode(password);
			User theUser = new User(1, password, "Tester Admin", "User", "admin address", 20, 'M', 1, "ROLE_ADMIN");
			userRepository.save(theUser);
		}
		*/
		String password = "12345";
		password = passwordEncoder.encode(password);
		User theUser = new User(1, password, "Tester Admin", "User", "admin address", 20, 'M', 1, "ROLE_ADMIN");
		userRepository.save(theUser);
		adminRepository.save(new Admin(theUser.getUserID()));
		
		password = "12345";
		password = passwordEncoder.encode(password);
		theUser = new User(2, password, "Tester Faculty", "User", "faculty address", 22, 'F', 1, "ROLE_FACULTY");
		userRepository.save(theUser);
		facultyRepository.save(new Faculty(theUser.getUserID()));
		
		password = "12345";
		password = passwordEncoder.encode(password);
		theUser = new User(3, password, "Tester Student", "User", "student address", 24, 'M', 1, "ROLE_STUDENT");
		userRepository.save(theUser);
		studentRepository.save(new Student(theUser.getUserID()));
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
		int theUserID = theUser.getUserID();
		// handle update user but no input password
		if(theUser.getPassword() == "") { // if no password is input
			Optional<User> result = userRepository.findById(theUserID);
			// find if the user already exist
			if(result.isPresent()) { // user exist
				theUser.setPassword(result.get().getPassword());
				userRepository.save(theUser);
			}else { // user dont exist (new user)
				// do nothing
			}
		}else {
			//encode the password
			String password = theUser.getPassword(); 
			password = passwordEncoder.encode(password);
			theUser.setPassword(password);
	
			userRepository.save(theUser);
		}
		
		String userrole = theUser.getRole();
		if(userrole.equals("ROLE_STUDENT")) {
			studentRepository.save(new Student(theUserID));
		}
		else if(userrole.equals("ROLE_ADMIN")) {
			adminRepository.save(new Admin(theUserID));
		}
		else if(userrole.equals("ROLE_FACULTY")) {
			facultyRepository.save(new Faculty(theUserID));
		}
	}

	@Override
	public void deleteById(int theUserID) {
		Optional<User> result = userRepository.findById(theUserID);
		if(result.isPresent()) {
			String userrole = result.get().getRole();
			if(userrole.equals("ROLE_STUDENT"))
				studentRepository.deleteById(theUserID);
			else if(userrole.equals("ROLE_ADMIN"))
				adminRepository.deleteById(theUserID);
			else if(userrole.equals("ROLE_FACULTY"))
				facultyRepository.deleteById(theUserID);
			
			
			userRepository.deleteById(theUserID);
		}
	}
	

	@Override
	public List<User> findAllStudent() {
		return userRepository.findByRoleEquals("ROLE_STUDENT");
	}

	@Override
	public List<User> findAllFaculty() {
		return userRepository.findByRoleEquals("ROLE_FACULTY");
	}

	@Override
	public List<User> findAllAdmin() {
		return userRepository.findByRoleEquals("ROLE_ADMIN");
	}
}
