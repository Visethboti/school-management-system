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
import com.visethboti.portfolio.schoolmanagementsystem.entity.AssignmentStudentGrade;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.AssignmentService;
import com.visethboti.portfolio.schoolmanagementsystem.service.AssignmentStudentGradeService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping("/facultyhome/sectioncontent")
public class FacultySectionController {
	
	private SectionService sectionService;
	private AssignmentService assignmentService;
	private UserService userService;
	private AssignmentStudentGradeService assignmentStudentGradeService;
	
	@Autowired
	public FacultySectionController(@Qualifier("sectionServiceImpl") SectionService sectionService,
											@Qualifier("assignmentServiceImpl") AssignmentService assignmentService,
											@Qualifier("userServiceImpl") UserService userService,
											AssignmentStudentGradeService assignmentStudentGradeService) {
		this.sectionService = sectionService;
		this.assignmentService = assignmentService;
		this.userService = userService;
		this.assignmentStudentGradeService = assignmentStudentGradeService;
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
	
	@GetMapping("/classlist/studentgrades")
	public String showStudentGrade(@RequestParam("sectionID") int theSectionID, @RequestParam("studentID") int studentID, 
			Model theModel) {
		
		Section section = sectionService.findById(theSectionID);
		User student = userService.findById(studentID);
		List<Assignment> assignmentList = assignmentService.findAllBySectionID(theSectionID);
		List<AssignmentStudentGrade> assignmentStudentGradeList = assignmentStudentGradeService.findAllBySectionIDAndStudentID(theSectionID, studentID);
		
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignmentList", assignmentList);
		theModel.addAttribute("assignmentStudentGradeList", assignmentStudentGradeList);
		theModel.addAttribute("student", student);
		
		return "/faculty-home/student-grades";
	}
	
	@PostMapping("/classlist/addgrade")
	public String processSaveGrade(@RequestParam("assignmentID") int theAssignmentID, 
			@RequestParam("sectionID") int sectionID, 
			@ModelAttribute("assignmentStudentGradeList[iterStat.index]") AssignmentStudentGrade assignmentStudentGrade) {
		
		assignmentStudentGradeService.save(assignmentStudentGrade);
		
		return "redirect:/facultyhome/sectioncontent/classlist/studentgrades?sectionID="+ sectionID + "&studentID=" + assignmentStudentGrade.getStudentID();
	}
	
	/*
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	*/
}
