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
@RequestMapping("/adminhome/userdirectory/facultydirectory")
public class FacultyDirectoryController {
	private UserService userService;
	
	@Autowired
	public FacultyDirectoryController(@Qualifier("userServiceImpl") UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping(value={"", "/"})
	public String listFaculty(Model theModel) {
		// get all Students
		List<User> facultyUser = userService.findAllFaculty();
		
		// add to the Spring MVC model
		theModel.addAttribute("users", facultyUser);
		
		return "/admin-home/faculty-directory";
	}
	
	@GetMapping("/addfaculty")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "/admin-home/add-faculty";
	}
	
	@PostMapping("/save")
	public String processSaveFaculty(@ModelAttribute("User") User theUser) {
		// save Student
		userService.save(theUser);
		
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/userdirectory/facultydirectory";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("userID") int theID, Model theModel) {
		theModel.addAttribute("user", userService.findById(theID));
		return "/admin-home/update-faculty";
	}
	
	@GetMapping("/delete")
	public String processUpdateFaculty(@RequestParam("userID") int theID) {
		userService.deleteById(theID);
		return "redirect:/adminhome/userdirectory/facultydirectory";
	}
}
