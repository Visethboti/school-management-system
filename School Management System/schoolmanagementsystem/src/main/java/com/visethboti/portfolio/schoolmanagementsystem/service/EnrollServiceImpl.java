package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.EnrollRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Enroll;

@Service
public class EnrollServiceImpl implements EnrollService {

	private EnrollRepository enrollRepository;
	private AssignmentStudentGradeService assignmentStudentGradeService;
	
	@Autowired
	public EnrollServiceImpl(EnrollRepository theEnrollRepository, AssignmentStudentGradeService assignmentStudentGradeService) {
		this.enrollRepository = theEnrollRepository;
		this.assignmentStudentGradeService = assignmentStudentGradeService;
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
		theEnroll = enrollRepository.save(theEnroll);
		
		// create new assignmentStudentGrade for each existing assignments in this section fo9r this student
		assignmentStudentGradeService.createAssignmentStudentGradesForNewStudentEnroll(theEnroll);
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
}
