package com.visethboti.portfolio.schoolmanagementsystem.controller.facultyhome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Assignment;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Submission;
import com.visethboti.portfolio.schoolmanagementsystem.service.AssignmentService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SubmissionService;

@Controller
@RequestMapping("/facultyhome/sectioncontent/submissions")
public class FacultyAssignmentSubmissionController {
	
	private SectionService sectionService;
	private AssignmentService assignmentService;
	private SubmissionService submissionService;
	
	@Autowired
	public FacultyAssignmentSubmissionController(@Qualifier("sectionServiceImpl") SectionService sectionService,
											@Qualifier("assignmentServiceImpl") AssignmentService assignmentService,
											@Qualifier("submissionServiceImpl") SubmissionService submissionService) {
		this.sectionService = sectionService;
		this.assignmentService = assignmentService;
		this.submissionService = submissionService;
	}
	
	@GetMapping("")
	public String showSectionContent(@RequestParam("assignmentID") int theAssignmentID, Model theModel) {
		
		Assignment assignment = assignmentService.findById(theAssignmentID);	
		Section section = sectionService.findById(assignment.getSectionID());
		List<List<Submission>> submissionlist = submissionService.GetListofStudentSubmissions(theAssignmentID);
		
		theModel.addAttribute("assignments", assignment);
		theModel.addAttribute("section", section);
		theModel.addAttribute("submissions", submissionlist);
		
		return "/faculty-home/assignment-student-submissions";
	}
	
	@PostMapping("/addgrade")
	public String saveGrade(@RequestParam("assignmentID") int theAssignmentID, 
			@ModelAttribute("tempSubmission") Submission theSubmission, Model theModel) {
		
		submissionService.save(theSubmission);
		
		Assignment assignment = assignmentService.findById(theAssignmentID);	
		Section section = sectionService.findById(assignment.getSectionID());
		List<List<Submission>> submissionlist = submissionService.GetListofStudentSubmissions(theAssignmentID);
		
		theModel.addAttribute("assignments", assignment);
		theModel.addAttribute("section", section);
		theModel.addAttribute("submissions", submissionlist);
		
		return "/faculty-home/assignment-student-submissions";
	}
	
	/*
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	*/
}
