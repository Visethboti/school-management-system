package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.EnrollRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.SectionRepository;
import com.visethboti.portfolio.schoolmanagementsystem.dao.UserRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Enroll;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;

@Service
public class EnrollServiceImpl implements EnrollService {

	private EnrollRepository enrollRepository;
	private SectionRepository sectionRepository;
	private UserRepository userRepository;
	
	@Autowired
	public EnrollServiceImpl(EnrollRepository theEnrollRepository, SectionRepository sectionRepository, UserRepository userRepository) {
		this.enrollRepository = theEnrollRepository;
		this.sectionRepository = sectionRepository;
		this.userRepository = userRepository;
	}
	
	@Override
	public List<Enroll> findAll() {
		return enrollRepository.findAll();
	}

	@Override
	public Enroll findById(int theSectionID, int theStudentID) {
		return enrollRepository.findBySectionIDAndStudentID(theSectionID, theSectionID);
	}

	@Override
	public void save(Enroll theEnroll) {
		enrollRepository.save(theEnroll);
	}

	@Override
	public void deleteById(int theSectionID, int theStudentID) {
		enrollRepository.deleteBySectionIDAndStudentID(theSectionID, theStudentID);
	}

	@Override
	public List<Enroll> findAllBySectionID(int theSectionID) {
		return enrollRepository.findAllBySectionIDEquals(theSectionID);
	}

	@Override
	public List<Enroll> findAllByStudentID(int theStudentID) {
		return enrollRepository.findAllByStudentIDEquals(theStudentID);
	}

	@Override
	public void deleteAllBySectionID(int theSectionID) {
		enrollRepository.deleteAllBySectionID(theSectionID);
	}
	
	@Override
	public void deleteAllByStudentID(int theStudentID) {
		enrollRepository.deleteAllByStudentID(theStudentID);
	}
	
	@Override
	public List<Section> getSectionsByStudentID(int theStudentID) {
		return sectionRepository.getAllSectionsEnrollByStudentID(theStudentID);
	}
	
	@Override
	public List<User> getStudentsEnrollBySectionID(int theSectionID) {
		return userRepository.getAllStudentsEnrollBySectionID(theSectionID);
	}
}
