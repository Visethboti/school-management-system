package com.visethboti.portfolio.schoolmanagementsystem.controller.adminhome;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Course;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Enroll;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.CourseService;
import com.visethboti.portfolio.schoolmanagementsystem.service.EnrollService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping(value={"/adminhome/coursedirectory/sections/enrollments"})
public class EnrollController {
	private SectionService sectionService;
	private UserService userService;
	private EnrollService enrollService;
	private CourseService courseService;
	
	@Autowired
	public EnrollController(@Qualifier("sectionServiceImpl") SectionService theSectionService, 
			@Qualifier("userServiceImpl") UserService theUserService,
			@Qualifier("enrollServiceImpl") EnrollService theEnrollService,
			@Qualifier("courseServiceImpl") CourseService theCourseService) {
		sectionService = theSectionService;
		userService = theUserService;
		enrollService = theEnrollService;
		courseService = theCourseService;
	}
	
	@GetMapping(value={"", "/"})
	public String listSections(@RequestParam("sectionID") int theSectionID, Model theModel) {
		// get all Sections for this course
		List<Enroll> enrolls = enrollService.findAllBySectionID(theSectionID);
		
		// add to the Spring MVC model
		theModel.addAttribute("enrolls", enrolls);
		theModel.addAttribute("sectionID", theSectionID);
		
		return "/admin-home/enroll-list";
	}
	
	@GetMapping("/enrollstudent")
	public String showFormForAdd(@RequestParam("sectionID") int theSectionID, Model theModel) {
		// create model attribute to bind form data
		
		Enroll theEnroll = new Enroll();
		Section theSection = sectionService.findById(theSectionID);
		List<User> theStudents = userService.findAllStudent();
		Course theCourse = courseService.findById(theSection.getCourseID());
			
		theModel.addAttribute("enroll", theEnroll);
		theModel.addAttribute("section", theSection);
		theModel.addAttribute("users", theStudents);
		theModel.addAttribute("course", theCourse);
		
		return "/admin-home/enroll-student";
	}
	
	@GetMapping("/save")
	public String saveSection(@RequestParam("sectionID") int theSectionID, @RequestParam("userID") int theStudentID, Model theModel) {
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		
		Enroll theEnroll = new Enroll(theStudentID,theSectionID, timestamp.toString(), '-');
		
		// save Section
		enrollService.save(theEnroll);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/coursedirectory/sections/enrollments?sectionID="+theEnroll.getSectionID();
	}
	
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam("sectionID") int theSectionID, @RequestParam("userID") int theStudentID, Model theModel) {
		Enroll theEnroll = enrollService.findById(theSectionID, theStudentID);
		theModel.addAttribute("section", sectionService.findById(theSectionID));
		theModel.addAttribute("enroll", theEnroll);
		return "/admin-home/update-section";
	}
	
	@GetMapping("/delete")
	public String updateSection(@RequestParam("sectionID") int theSectionID, @RequestParam("userID") int theStudentID) {
		enrollService.deleteById(theSectionID, theStudentID);
		return "redirect:/adminhome/coursedirectory/sections/enrollments?sectionID="+theSectionID;
	}
}
