package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.TeachRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Teach;

@Service
public class TeachServiceImpl implements TeachService {

	private TeachRepository teachRepository;
	
	@Autowired
	public TeachServiceImpl(TeachRepository theTeachRepository) {
		this.teachRepository = theTeachRepository;
	}
	
	@Override
	public List<Teach> findAll() {
		return teachRepository.findAll();
	}

	@Override
	public Teach findById(int theSectionID, int theFacultyID) {
		return teachRepository.findBySectionIDAndFacultyID(theSectionID, theSectionID);
	}

	@Override
	public void save(Teach theTeach) {
		teachRepository.save(theTeach);
	}

	@Override
	public void deleteById(int theSectionID, int theFacultyID) {
		teachRepository.deleteBySectionIDAndFacultyID(theSectionID, theFacultyID);
	}

	@Override
	public List<Teach> findAllBySectionID(int theSectionID) {
		return teachRepository.findAllBySectionIDEquals(theSectionID);
	}

	@Override
	public List<Teach> findAllByFacultyID(int theFacultyID) {
		return teachRepository.findAllByFacultyIDEquals(theFacultyID);
	}

	@Override
	public void deleteAllBySectionID(int theSectionID) {
		teachRepository.deleteAllBySectionIDEquals(theSectionID);
	}
	
	@Override
	public void deleteAllByFacultyID(int theFacultyID) {
		teachRepository.deleteAllByFacultyIDEquals(theFacultyID);
	}
	
	
}
