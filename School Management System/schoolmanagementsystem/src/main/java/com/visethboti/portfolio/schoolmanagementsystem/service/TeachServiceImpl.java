package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.TeachRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Teach;

@Service
public class TeachServiceImpl implements TeachService {

	private TeachRepository enrollRepository;
	
	@Autowired
	public TeachServiceImpl(TeachRepository theTeachRepository) {
		this.enrollRepository = theTeachRepository;
	}
	
	@Override
	public List<Teach> findAll() {
		return enrollRepository.findAll();
	}

	@Override
	public Teach findById(int theSectionID, int theFacultyID) {
		return enrollRepository.findBySectionIDAndFacultyID(theSectionID, theSectionID);
	}

	@Override
	public void save(Teach theTeach) {
		enrollRepository.save(theTeach);
	}

	@Override
	public void deleteById(int theSectionID, int theFacultyID) {
		enrollRepository.deleteBySectionIDAndFacultyID(theSectionID, theFacultyID);
	}

	@Override
	public List<Teach> findAllBySectionID(int theSectionID) {
		return enrollRepository.findAllBySectionIDEquals(theSectionID);
	}

	@Override
	public List<Teach> findAllByFacultyID(int theFacultyID) {
		return enrollRepository.findAllByFacultyIDEquals(theFacultyID);
	}

	@Override
	public void deleteAllBySectionID(int theSectionID) {
		enrollRepository.deleteAllBySectionID(theSectionID);
	}
	
	@Override
	public void deleteAllByFacultyID(int theFacultyID) {
		enrollRepository.deleteAllByFacultyID(theFacultyID);
	}
}
