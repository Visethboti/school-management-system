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

import com.visethboti.portfolio.schoolmanagementsystem.entity.Section;
import com.visethboti.portfolio.schoolmanagementsystem.service.CourseService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;

@Controller
@RequestMapping(value={"/adminhome/sectiondirectory"})
public class SectionDirectoryController {
	private SectionService sectionService;
	private CourseService courseService;
	
	@Autowired
	public SectionDirectoryController(@Qualifier("sectionServiceImpl") SectionService sectionService, CourseService courseService) {
		this.sectionService = sectionService;
		this.courseService = courseService;
	}
	
	@GetMapping(value={"", "/"})
	public String listCourses(Model theModel, @RequestParam("sectionIndex") int sectionIndex,
			@RequestParam("search") String search) {
		
		// get all Courses
		List<Section> sections = sectionService.findAllByBatchOfTenAndSearch(sectionIndex, search);

		theModel.addAttribute("sections", sections);
		theModel.addAttribute("sectionIndex", sectionIndex);
		theModel.addAttribute("search", search);
		
		return "/admin-home/section-directory";
	}
	
	@PostMapping("/save")
	public String processSaveSection(@ModelAttribute("Section") Section theSection) {
		// save Section
		sectionService.save(theSection);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/sectiondirectory?sectionIndex=0&search=";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("sectionID") int theID, Model theModel) {
		Section section = sectionService.findById(theID);
		theModel.addAttribute("section", section);
		theModel.addAttribute("course", courseService.findById(section.getCourseID()));
		return "/admin-home/update-section-section-directory";
	}
	
	@GetMapping("/delete")
	public String processUpdateSection(@RequestParam("sectionID") int theID) {
		sectionService.deleteById(theID);
		return "redirect:/adminhome/sectiondirectory?sectionIndex=0&search=";
	}
}
