package com.visethboti.portfolio.schoolmanagementsystem.controller.facultyhome;

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
@RequestMapping("/facultyhome")
public class FacultyHomeController {
	
	private SectionService sectionService;
	
	@Autowired
	public FacultyHomeController(@Qualifier("sectionServiceImpl") SectionService sectionService) {
		this.sectionService = sectionService;
	}
	
	@GetMapping("")
	public String showAdminHomePage(Model theModel, Authentication authentication) {
		
		List<Section> teachingSections = sectionService.findSectionsByFacultyIDTeach(Integer.parseInt(authentication.getName())); // authentication.getName() return the userID of the current autheticated user
		
		theModel.addAttribute("sections", teachingSections);
		
		return "/faculty-home/faculty-home";
	}
	
	
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	
}
