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
import com.visethboti.portfolio.schoolmanagementsystem.service.AssignmentService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;

@Controller
@RequestMapping("/facultyhome/sectioncontent")
public class FacultySectionContentController {
	
	private SectionService sectionService;
	private AssignmentService assignmentService;
	
	@Autowired
	public FacultySectionContentController(@Qualifier("sectionServiceImpl") SectionService sectionService,
											@Qualifier("assignmentServiceImpl") AssignmentService assignmentService) {
		this.sectionService = sectionService;
		this.assignmentService = assignmentService;
	}
	
	@GetMapping("")
	public String showSectionContent(@RequestParam("sectionID") int theSectionID, Model theModel) {
		
		Section section = sectionService.findById(theSectionID);
		List<Assignment> assignments = assignmentService.findAllBySectionID(theSectionID);	
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignments", assignments);
		
		return "/faculty-home/faculty-section-content";
	}
	
	@GetMapping("/addassignment")
	public String showAddAssignment(@RequestParam("sectionID") int theSectionID, Model theModel) {
		
		Section section = sectionService.findById(theSectionID);
		Assignment assignment = new Assignment();
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignment", assignment);
		
		return "/faculty-home/add-assignment";
	}
	
	@PostMapping("/saveassignment")
	public String saveAssignment(@ModelAttribute("Assignment") Assignment assignment,
			@RequestParam("sectionID") int theSectionID) {
		
		assignmentService.save(assignment);
		
		return "redirect:/facultyhome/sectioncontent?sectionID="+theSectionID;
	}
	
	@GetMapping("/deleteassignment")
	public String deleteAssignment(@RequestParam("assignmentID") int theAssignmentID,
			@RequestParam("sectionID") int theSectionID) {
		
		assignmentService.deleteById(theAssignmentID);
		
		return "redirect:/facultyhome/sectioncontent?sectionID="+theSectionID;
	}
	
	/*
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	*/
}
