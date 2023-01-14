package com.visethboti.portfolio.schoolmanagementsystem.controller.adminhome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminhome")
public class AdminHomeController {
	
	@GetMapping(value={""})
	public String showAdminHomePage() {
		
		return "/admin-home/admin-home";
	}
	
	
	/*@GetMapping(value={"/**"})
	public String redirectToHomePage() {
		
		return "redirect:/";
	}
	*/
}
