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

import com.visethboti.portfolio.schoolmanagementsystem.entity.Student;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.StudentService;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping(value={"/adminhome/studentdirectory"})
public class StudentDirectoryController {
	private StudentService studentService;
	private UserService userService;
	
	@Autowired
	public StudentDirectoryController(@Qualifier("studentServiceImpl") StudentService theStudentService,@Qualifier("userServiceImpl") UserService theUserService) {
		studentService = theStudentService;
	}
	
	@GetMapping(value={"", "/"})
	public String listStudents(Model theModel) {
		// get all Students
		List<Student> Students = studentService.findAll();
		
		// add to the Spring MVC model
		theModel.addAttribute("students", Students);
		
		return "student-directory";
	}
	
	@GetMapping("/addstudent")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "add-student";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("User") User theUser) {
		
		
		Student theStudent = new Student(theUser.getUserID());
		
		// save Student
		studentService.save(theStudent);
		userService.save(theUser);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/studentdirectory";
	}
}
