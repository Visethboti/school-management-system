package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.FacultyRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Faculty;

@Service
public class FacultyServiceImpl implements FacultyService {

	
	private FacultyRepository facultyRepository;

	@Autowired
	public FacultyServiceImpl(FacultyRepository theFacultyRepository) {
		this.facultyRepository = theFacultyRepository;
	}
	
	@Override
	public List<Faculty> findAll() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty findById(int theFacultyID) {
		Optional<Faculty> result = facultyRepository.findById(theFacultyID);
		
		Faculty theFaculty = null;
		
		if(result.isPresent()) {
			theFaculty = result.get();
		} else {
			// didnt find the faculty
			throw new RuntimeException("Did not find faculty id - " + theFacultyID);
		}
		
		return theFaculty;
	}

	@Override
	public void save(Faculty theFaculty) {
		facultyRepository.save(theFaculty);
	}

	@Override
	public void deleteById(int theFacultyID) {
		facultyRepository.deleteById(theFacultyID);
	}

}
