package com.visethboti.portfolio.schoolmanagementsystem.controller.studenthome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;

@Controller
@RequestMapping("/studenthome")
public class StudentHomeController {
	
	private SectionService sectionService;
	
	@Autowired
	public StudentHomeController(@Qualifier("sectionServiceImpl") SectionService sectionService) {
		this.sectionService = sectionService;
	}
	
	@GetMapping("")
	public String showStudentHomePage(Model theModel, Authentication authentication) {
		
		List<Section> enrollingSections = sectionService.findSectionsByStudentIDEnroll(Integer.parseInt(authentication.getName())); // authentication.getName() return the userID of the current autheticated user
		
		theModel.addAttribute("sections", enrollingSections);
		
		return "/student-home/student-home";
	}
	
	
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	
}
