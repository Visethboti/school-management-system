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
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.AssignmentService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping("/facultyhome/sectioncontent")
public class FacultySectionController {
	
	private SectionService sectionService;
	private AssignmentService assignmentService;
	private UserService userService;
	
	@Autowired
	public FacultySectionController(@Qualifier("sectionServiceImpl") SectionService sectionService,
											@Qualifier("assignmentServiceImpl") AssignmentService assignmentService,
											@Qualifier("userServiceImpl") UserService userService) {
		this.sectionService = sectionService;
		this.assignmentService = assignmentService;
		this.userService = userService;
	}
	
	@GetMapping("")
	public String listAssignmentsForThisSection(@RequestParam("sectionID") int theSectionID, Model theModel) {
		
		Section section = sectionService.findById(theSectionID);
		List<Assignment> assignments = assignmentService.findAllBySectionID(theSectionID);	
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignments", assignments);
		
		return "/faculty-home/faculty-section-content";
	}
	
	@GetMapping("/addassignment")
	public String showFormForAddAssignment(@RequestParam("sectionID") int theSectionID, Model theModel) {
		
		Section section = sectionService.findById(theSectionID);
		Assignment assignment = new Assignment();
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignment", assignment);
		
		return "/faculty-home/add-assignment";
	}
	
	@PostMapping("/saveassignment")
	public String processSaveAssignment(@ModelAttribute("Assignment") Assignment assignment,
			@RequestParam("sectionID") int theSectionID) {
		
		assignmentService.save(assignment);
		
		return "redirect:/facultyhome/sectioncontent?sectionID="+theSectionID;
	}
	
	@GetMapping("/deleteassignment")
	public String processDeleteAssignment(@RequestParam("assignmentID") int theAssignmentID,
			@RequestParam("sectionID") int theSectionID) {
		
		assignmentService.deleteById(theAssignmentID);
		
		return "redirect:/facultyhome/sectioncontent?sectionID="+theSectionID;
	}
	
	@GetMapping("/classlist")
	public String showClasslist(@RequestParam("sectionID") int theSectionID, Model theModel) {
		
		Section section = sectionService.findById(theSectionID);
		List<User> students = userService.findStudentsEnrollBySectionID(theSectionID);
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("students", students);
		
		return "/faculty-home/classlist";
	}
	
	/*
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	*/
}
