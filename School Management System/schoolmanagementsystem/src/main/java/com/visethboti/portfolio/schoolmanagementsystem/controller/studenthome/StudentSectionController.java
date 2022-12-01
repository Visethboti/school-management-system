package com.visethboti.portfolio.schoolmanagementsystem.controller.studenthome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Assignment;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.AssignmentService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping("/studenthome/sectioncontent")
public class StudentSectionController {
	
	private SectionService sectionService;
	private AssignmentService assignmentService;
	private UserService userService;
	
	@Autowired
	public StudentSectionController(@Qualifier("sectionServiceImpl") SectionService sectionService,
											@Qualifier("assignmentServiceImpl") AssignmentService assignmentService,
											@Qualifier("userServiceImpl") UserService userService) {
		this.sectionService = sectionService;
		this.assignmentService = assignmentService;
		this.userService = userService;
	}
	
	@GetMapping("")
	public String listSectionAssignments(@RequestParam("sectionID") int theSectionID, Model theModel) {
		
		Section section = sectionService.findById(theSectionID);
		List<Assignment> assignments = assignmentService.findAllBySectionID(theSectionID);	
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignments", assignments);
		
		return "/student-home/student-section-content";
	}
	
	@GetMapping("/classlist")
	public String showClasslist(@RequestParam("sectionID") int theSectionID, Model theModel) {
		
		Section section = sectionService.findById(theSectionID);
		List<User> students = userService.findStudentsEnrollBySectionID(theSectionID);
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("students", students);
		
		return "/student-home/classlist";
	}
	
	/*
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	*/
}
