package com.visethboti.portfolio.schoolmanagementsystem.controller.adminhome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping(value={"/adminhome/userdirectory"})
public class UserDirectoryController {
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserDirectoryController(@Qualifier("userServiceImpl") UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping(value={"", "/"})
	public String listUsers(Model theModel) {
		// get all Users
		List<User> Users = userService.findAll();
		
		// add to the Spring MVC model
		theModel.addAttribute("users", Users);
		
		return "user-directory";
	}
	
	@GetMapping("/adduser")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "add-user";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("User") User theUser) {
		// save User
		userService.save(theUser);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/userdirectory";
	}
}
