package com.visethboti.portfolio.schoolmanagementsystem.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/"})
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "login";
	}
	
	// add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		
		return "access-denied";
		
	}
	
	@GetMapping("")
    public String redirectOnLogin(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
        	String role = auth.getAuthorities().toString();
        	
        	if(role.contains("ROLE_ADMIN"))
        		return "redirect:/adminhome";
        	else if(role.contains("ROLE_STUDENT"))
        		return "redirect:/studenthome";
        	else if(role.contains("ROLE_FACULTY"))
        		return "redirect:/facultyhome";
        }
           
        return "redirect:/";
    }
	
}