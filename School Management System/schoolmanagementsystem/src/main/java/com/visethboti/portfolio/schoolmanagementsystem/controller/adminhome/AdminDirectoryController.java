package com.visethboti.portfolio.schoolmanagementsystem.controller.adminhome;

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

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping("/adminhome/userdirectory/admindirectory")
public class AdminDirectoryController {
	private UserService userService;
	
	@Autowired
	public AdminDirectoryController(@Qualifier("userServiceImpl") UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping(value={"", "/"})
	public String listAdmins(Model theModel) {
		// get all Students
		List<User> adminUser = userService.findAllAdmin();
		
		// add to the Spring MVC model
		theModel.addAttribute("users", adminUser);
		
		return "/admin-home/admin-directory";
	}
	
	@GetMapping("/addadmin")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "/admin-home/add-admin";
	}
	
	@PostMapping("/save")
	public String saveAdmin(@ModelAttribute("User") User theUser) {
		// save Student
		userService.save(theUser);
		
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/userdirectory/admindirectory";
	}
	
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam("userID") int theID, Model theModel) {
		theModel.addAttribute("user", userService.findById(theID));
		return "/admin-home/update-admin";
	}
	
	@GetMapping("/delete")
	public String updateAdmin(@RequestParam("userID") int theID) {
		userService.deleteById(theID);
		return "redirect:/adminhome/userdirectory/admindirectory";
	}
}
