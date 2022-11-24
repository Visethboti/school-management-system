package com.visethboti.portfolio.schoolmanagementsystem.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	// After login spring security redirect to "/", so here we check for role and redirect to each home page accordingly
	@RequestMapping("/")
    public String index(Model model) {
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
