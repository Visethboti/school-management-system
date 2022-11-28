package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.SectionRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;

@Service
public class SectionServiceImpl implements SectionService {

	
	private SectionRepository sectionRepository;
	
	@Autowired
	public SectionServiceImpl(SectionRepository theSectionRepository) {
		this.sectionRepository = theSectionRepository;
	}
	
	@Override
	public List<Section> findAll() {
		return sectionRepository.findAll();
	}

	@Override
	public Section findById(int theSectionID) {
		Optional<Section> result = sectionRepository.findById(theSectionID);
		
		Section theSection = null;
		
		if(result.isPresent()) {
			theSection = result.get();
		} else {
			// didnt find the section
			throw new RuntimeException("Did not find section id - " + theSectionID);
		}
		
		return theSection;
	}

	@Override
	public void save(Section theSection) {
		sectionRepository.save(theSection);
	}

	@Override
	public void deleteById(int theSectionID) {
		sectionRepository.deleteById(theSectionID);
	}

	@Override
	public List<Section> findAllByCourseID(int theCourseID) {
		return sectionRepository.findAllByCourseIDEquals(theCourseID);
	}
	
	@Override
	public void deleteAllByCourseIDEquals(int theCourseID) {
		sectionRepository.deleteAllByCourseIDEquals(theCourseID);
	}
}
