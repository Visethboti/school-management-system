package com.visethboti.portfolio.schoolmanagementsystem.controller.studenthome;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/studenthome/sectioncontent/submissions")
public class StudentAssignmentSubmissionController {
	
	private SectionService sectionService;
	private SubmissionService submissionService;
	private AssignmentService assignmentService;
	
	@Autowired
	public StudentAssignmentSubmissionController(@Qualifier("sectionServiceImpl") SectionService sectionService,
											@Qualifier("submissionServiceImpl") SubmissionService submissionService,
											@Qualifier("assignmentServiceImpl") AssignmentService assignmentService) {
		this.sectionService = sectionService;
		this.submissionService = submissionService;
		this.assignmentService = assignmentService;
	}
	
	@GetMapping("")
	public String showSubmission(@RequestParam("assignmentID") int theAssignmentID, 
		Authentication authentication, Model theModel) {
		
		Assignment assignment = assignmentService.findById(theAssignmentID);
		Section section = sectionService.findById(assignment.getSectionID());
		List<Submission> submissions = submissionService.findAllByAssignmentIDAndStudentID(theAssignmentID, Integer.parseInt(authentication.getName()));	
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignment", assignment);
		theModel.addAttribute("submissions", submissions);
		
		return "/student-home/submissions";
	}
	
	@GetMapping("/addsubmission")
	public String showAddsubmission(@RequestParam("assignmentID") int theAssignmentID, 
			Authentication authentication, Model theModel) {
		
		Assignment assignment = assignmentService.findById(theAssignmentID);
		Section section = sectionService.findById(assignment.getSectionID());
		Submission submission = new Submission();
		
		// populate submission
		submission.setStudentID(Integer.parseInt(authentication.getName()));
		submission.setAssignmentID(theAssignmentID);
		submission.setSubmissionGrade(0);
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignment", assignment);
		theModel.addAttribute("submission", submission);
		
		return "/student-home/add-submission";
	}
	
	@PostMapping("/addsubmission")
	public String showAddsubmission(@ModelAttribute("Submission") Submission submission, @RequestParam("assignmentID") int theAssignmentID) {
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		submission.setSubmissionDate(timestamp.toString());
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&" + submission.toString());
		submissionService.save(submission);
		
		return "redirect:/studenthome/sectioncontent/submissions?assignmentID="+theAssignmentID;
	}
	
	/*
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	*/
}
