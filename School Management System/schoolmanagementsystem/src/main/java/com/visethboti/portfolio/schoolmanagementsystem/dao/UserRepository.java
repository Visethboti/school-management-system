package com.visethboti.portfolio.schoolmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByRoleEquals(String role);
	
	@Query(nativeQuery=true, value="select * from User where User.userID in (select Enroll.studentID from Enroll where Enroll.sectionID = ?1)")
	List<User> findAllStudentsEnrollBySectionID(int theSectionID);
	
	@Query(nativeQuery=true, value="select * from User where User.role = 'ROLE_STUDENT' and User.userID not in (select Enroll.studentID from Enroll where Enroll.sectionID = ?1)")
	List<User> findAllStudentNotEnrollBySectionID(int theSectionID);
	
	@Query(nativeQuery=true, value="select * from User where User.role = 'ROLE_FACULTY' and User.userID not in (select Teach.facultyID from Teach where Teach.sectionID = ?1)")
	List<User> findAllFacultyNotAssignBySectionID(int theSectionID);
	
	@Query(nativeQuery=true, value="select * from User order by User.userID limit ?1,10")
	public List<User> findAllByBatchOfTen(int userIndex);
	
	@Query(nativeQuery=true, value="select * from User where User.userID = ?2 or User.firstName like ?3 or User.lastName like ?3 order by User.userID limit ?1,10")
	public List<User> findAllByBatchOfTenAndSearch(int userIndex, int searchID, String searchKey);
	
	@Query(nativeQuery=true, value="select * from User where User.role = ?2 order by User.userID limit ?1,10")
	public List<User> findAllByBatchOfTenByUserRole(int userIndex, String userRole);
	
	@Query(nativeQuery=true, value="select * from User where User.role = ?4 and User.userID = ?2 or User.firstName like ?3 or User.lastName like ?3 order by User.userID limit ?1,10")
	public List<User> findAllByBatchOfTenAndSearchByUserRole(int userIndex,  int searchID, String searchKey, String userRole);
	
	
	@Query(nativeQuery=true, value="select * from User where User.role = 'ROLE_STUDENT' and User.userID not in (select Enroll.studentID from Enroll where Enroll.sectionID = ?1) order by User.userID limit ?2,10")
	public List<User> findAllStudentNotEnrollInSectionByBatchOfTen(int sectionID, int userIndex);
	
	@Query(nativeQuery=true, value="select * from User where (User.userID = ?3 or User.firstName like ?4 or User.lastName like ?4) and User.role = 'ROLE_STUDENT' and User.userID not in (select Enroll.studentID from Enroll where Enroll.sectionID = ?1) order by User.userID limit ?2,10")
	public List<User> findAllStudentNotEnrollInSectionBatchOfTenAndSearch(int sectionID, int userIndex,  int searchID, String searchKey);
	
	
	@Query(nativeQuery=true, value="select * from User where User.role = 'ROLE_FACULTY' and User.userID not in (select Teach.facultyID from Teach where Teach.sectionID = ?1) order by User.userID limit ?2,10")
	public List<User> findAllFacultyNotAssignInSectionByBatchOfTen(int sectionID, int userIndex);
	
	@Query(nativeQuery=true, value="select * from User where (User.userID = ?3 or User.firstName like ?4 or User.lastName like ?4) and User.role = 'ROLE_FACULTY' and User.userID not in (select Teach.facultyID from Teach where Teach.sectionID = ?1) order by User.userID limit ?2,10")
	public List<User> findAllFacultyNotAssignInSectionBatchOfTenAndSearch(int sectionID, int userIndex,  int searchID, String searchKey);
}


