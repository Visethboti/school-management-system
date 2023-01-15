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
@RequestMapping("/adminhome/userdirectory/studentdirectory")
public class StudentDirectoryController {
	private UserService userService;
	
	@Autowired
	public StudentDirectoryController(@Qualifier("userServiceImpl") UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping(value={"", "/"})
	public String listStudents(Model theModel, @RequestParam("userIndex") int userIndex,
			@RequestParam("search") String search) {

		List<User> studentUser = userService.findAllByBatchOfTenAndSearchByUserRole(userIndex, search, "ROLE_STUDENT"); 
		
		// add to the Spring MVC model
		theModel.addAttribute("users", studentUser);
		theModel.addAttribute("userIndex", userIndex);
		theModel.addAttribute("search", search);
		
		return "/admin-home/student-directory";
	}
	
	@GetMapping("/addstudent")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "/admin-home/add-student";
	}
	
	@PostMapping("/save")
	public String processSaveStudent(@ModelAttribute("User") User theUser) {
		// save Student
		userService.save(theUser);
		
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/userdirectory/studentdirectory?userIndex=0&search=";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("userID") int theID, Model theModel) {
		theModel.addAttribute("user", userService.findById(theID));
		return "/admin-home/update-student";
	}
	
	@GetMapping("/delete")
	public String processUpdateStudent(@RequestParam("userID") int theID) {
		userService.deleteById(theID);
		return "redirect:/adminhome/userdirectory/studentdirectory?userIndex=0&search=";
	}
}
