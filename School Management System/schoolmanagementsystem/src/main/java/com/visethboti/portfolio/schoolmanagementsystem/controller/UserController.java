package com.visethboti.portfolio.schoolmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping(value={"/users"})
public class UserController {
private UserService userService;
	
	@Autowired
	public UserController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping(value={"", "/"})
	public String listUsers(Model theModel) {
		// get all Users
		List<User> Users = userService.findAll();
		
		// add to the Spring MVC model
		theModel.addAttribute("users", Users);
		
		return "list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "user-form.html";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("User") User theUser) {
		// save User
		userService.save(theUser);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}
}
