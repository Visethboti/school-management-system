package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findById(int theUserID);
	public void save(User theUser);
	public void deleteById(int theUserID);
	
	public List<User> findAllStudent();
	public List<User> findAllFaculty();
	public List<User> findAllAdmin();
	
	public List<User> findAllStudentNotEnrollInSection(int theSectionID);
	public List<User> findAllFacultyNotAssignInSection(int theSectionID);
	
	public List<User> findStudentsEnrollBySectionID(int theSectionID);
	
	public List<User> findAllByBatchOfTenAndSearch(int userIndex, String searchKey);
}
