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
import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;
import com.visethboti.portfolio.schoolmanagementsystem.service.CourseService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;

@Controller
@RequestMapping(value={"/adminhome/coursedirectory/sections"})
public class SectionsController {
	private SectionService sectionService;
	private CourseService courseService;
	
	@Autowired
	public SectionsController(@Qualifier("sectionServiceImpl") SectionService theSectionService, 
			@Qualifier("courseServiceImpl") CourseService theCourseService) {
		sectionService = theSectionService;
		courseService = theCourseService;
	}
	
	@GetMapping(value={"", "/"})
	public String listSections(@RequestParam("courseID") int theID, Model theModel) {
		// get all Sections for this course
		List<Section> Sections = sectionService.findAllByCourseID(theID);
		
		// add to the Spring MVC model
		theModel.addAttribute("sections", Sections);
		theModel.addAttribute("courseID", theID);
		
		return "/admin-home/section-list";
	}
	
	@GetMapping("/addsection")
	public String showFormForAdd(@RequestParam("courseID") int theID, Model theModel) {
		// create model attribute to bind form data
		
		Section theSection = new Section();
		Course theCourse = courseService.findById(theID);
		
		theModel.addAttribute("section", theSection);
		theModel.addAttribute("course", theCourse);
		
		return "/admin-home/add-section";
	}
	
	@PostMapping("/save")
	public String processSaveSection(@ModelAttribute("Section") Section theSection) {
		// save Section
		sectionService.save(theSection);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/coursedirectory/sections?courseID="+theSection.getCourseID();
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("sectionID") int theID, @RequestParam("courseID") int courseID, Model theModel) {
		theModel.addAttribute("section", sectionService.findById(theID));
		theModel.addAttribute("course", courseService.findById(courseID));
		return "/admin-home/update-section";
	}
	
	@GetMapping("/delete")
	public String processUpdateSection(@RequestParam("sectionID") int theID, @RequestParam("courseID") int courseID) {
		sectionService.deleteById(theID);
		return "redirect:/adminhome/coursedirectory/sections?courseID="+courseID;
	}
}
