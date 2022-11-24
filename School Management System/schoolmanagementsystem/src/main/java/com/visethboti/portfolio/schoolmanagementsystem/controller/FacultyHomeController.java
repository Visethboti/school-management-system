package com.visethboti.portfolio.schoolmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facultyhome")
public class FacultyHomeController {
	
	@GetMapping(value={""})
	public String showAdminHomePage() {
		
		return "faculty-home";
	}
	
	@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
}
