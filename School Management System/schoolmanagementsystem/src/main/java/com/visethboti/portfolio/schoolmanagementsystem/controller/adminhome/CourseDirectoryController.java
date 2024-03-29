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

import com.visethboti.portfolio.schoolmanagementsystem.entity.Course;
import com.visethboti.portfolio.schoolmanagementsystem.service.CourseService;

@Controller
@RequestMapping(value={"/adminhome/coursedirectory"})
public class CourseDirectoryController {
	private CourseService courseService;
	
	@Autowired
	public CourseDirectoryController(@Qualifier("courseServiceImpl") CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	@GetMapping(value={"", "/"})
	public String listCourses(Model theModel, @RequestParam("courseIndex") int courseIndex,
			@RequestParam("search") String search) {
		
		// get all Courses
		List<Course> Courses = courseService.findAllByBatchOfTenAndSearch(courseIndex, search);

		theModel.addAttribute("courses", Courses);
		theModel.addAttribute("courseIndex", courseIndex);
		theModel.addAttribute("search", search);
		
		return "/admin-home/course-directory";
	}
	
	@GetMapping("/addcourse")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		
		Course theCourse = new Course();
		
		theModel.addAttribute("course", theCourse);
		
		return "/admin-home/add-course";
	}
	
	@PostMapping("/save")
	public String processSaveCourse(@ModelAttribute("Course") Course theCourse) {
		// save Course
		courseService.save(theCourse);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/coursedirectory?courseIndex=0&search=";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("courseID") int theID, Model theModel) {
		theModel.addAttribute("course", courseService.findById(theID));
		return "/admin-home/update-course";
	}
	
	@GetMapping("/delete")
	public String processDeleteCourse(@RequestParam("courseID") int theID) {
		courseService.deleteById(theID);
		return "redirect:/adminhome/coursedirectory?courseIndex=0&search=";
	}
}
