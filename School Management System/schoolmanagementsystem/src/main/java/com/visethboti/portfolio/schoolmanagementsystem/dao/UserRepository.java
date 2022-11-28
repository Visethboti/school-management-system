package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByRoleEquals(String role);
	
	@Query(nativeQuery=true, value="select * from User where User.userID in (select Enroll.studentID from Enroll where Enroll.sectionID = ?1)")
	List<User> getAllStudentsEnrollBySectionID(int theSectionID);
	
	@Query(nativeQuery=true, value="select * from User where User.role = 'ROLE_STUDENT' and User.userID not in (select Enroll.studentID from Enroll where Enroll.sectionID = ?1)")
	List<User> getAllStudentNotEnrollBySectionID(int theSectionID);
	
	@Query(nativeQuery=true, value="select * from User where User.role = 'ROLE_FACULTY' and User.userID not in (select Teach.facultyID from Teach where Teach.sectionID = ?1)")
	List<User> getAllFacultyNotAssignBySectionID(int theSectionID);
}
