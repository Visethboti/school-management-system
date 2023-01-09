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
import com.visethboti.portfolio.schoolmanagementsystem.entity.Submission;
import com.visethboti.portfolio.schoolmanagementsystem.service.AssignmentService;
import com.visethboti.portfolio.schoolmanagementsystem.service.AssignmentStudentGradeService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SubmissionService;

@Controller
@RequestMapping("/facultyhome/sectioncontent/submissions")
public class FacultySubmissionController {
	
	private SectionService sectionService;
	private AssignmentService assignmentService;
	private SubmissionService submissionService;
	private AssignmentStudentGradeService assignmentStudentGradeService;
	
	@Autowired
	public FacultySubmissionController(@Qualifier("sectionServiceImpl") SectionService sectionService,
											@Qualifier("assignmentServiceImpl") AssignmentService assignmentService,
											@Qualifier("submissionServiceImpl") SubmissionService submissionService,
											AssignmentStudentGradeService assignmentStudentGradeService) {
		this.sectionService = sectionService;
		this.assignmentService = assignmentService;
		this.submissionService = submissionService;
		this.assignmentStudentGradeService = assignmentStudentGradeService;
	}
	
	@GetMapping("")
	public String listStudentsSubmissions(@RequestParam("assignmentID") int theAssignmentID, Model theModel) {
		
		Assignment assignment = assignmentService.findById(theAssignmentID);	
		Section section = sectionService.findById(assignment.getSectionID());
		List<AssignmentStudentGrade> assignmentStudentGradeList = assignmentStudentGradeService.findAllByAssignmentID(theAssignmentID);
		List<List<Submission>> submissionlist = submissionService.GetListofAllStudentSubmissions(assignmentStudentGradeList);
		
		theModel.addAttribute("assignment", assignment);
		theModel.addAttribute("section", section);
		theModel.addAttribute("assignmentStudentGradeList", assignmentStudentGradeList);
		theModel.addAttribute("submissions", submissionlist);
		
		return "/faculty-home/assignment-student-submissions";
	}
	
	@PostMapping("/addgrade")
	public String processSaveGrade(@RequestParam("assignmentID") int theAssignmentID, 
			@ModelAttribute("assignmentStudentGradeList[iterStat.index]") AssignmentStudentGrade assignmentStudentGrade) {
		
		assignmentStudentGradeService.save(assignmentStudentGrade);
		
		return "redirect:/facultyhome/sectioncontent/submissions?assignmentID="+assignmentStudentGrade.getAssignmentID();
	}
	
	/*
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	*/
}
