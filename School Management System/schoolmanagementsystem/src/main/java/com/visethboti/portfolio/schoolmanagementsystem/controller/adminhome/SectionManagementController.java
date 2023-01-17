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
import com.visethboti.portfolio.schoolmanagementsystem.entity.Teach;
import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.CourseService;
import com.visethboti.portfolio.schoolmanagementsystem.service.EnrollService;
import com.visethboti.portfolio.schoolmanagementsystem.service.SectionService;
import com.visethboti.portfolio.schoolmanagementsystem.service.TeachService;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@Controller
@RequestMapping(value={"/adminhome/coursedirectory/sections/management"})
public class SectionManagementController {
	private SectionService sectionService;
	private UserService userService;
	private EnrollService enrollService;
	private CourseService courseService;
	private TeachService teachService;
	
	@Autowired
	public SectionManagementController(@Qualifier("sectionServiceImpl") SectionService theSectionService, 
			@Qualifier("userServiceImpl") UserService theUserService,
			@Qualifier("enrollServiceImpl") EnrollService theEnrollService,
			@Qualifier("courseServiceImpl") CourseService theCourseService,
			@Qualifier("teachServiceImpl") TeachService theTeachService) {
		sectionService = theSectionService;
		userService = theUserService;
		enrollService = theEnrollService;
		courseService = theCourseService;
		teachService = theTeachService;
	}
	
	@GetMapping(value={"", "/"})
	public String listSectionStudentFaculty(@RequestParam("sectionID") int sectionID, 
			@RequestParam("courseID") int courseID, Model theModel,
			@RequestParam("studentIndex") int studentIndex,
			@RequestParam("studentSearch") String studentSearch,
			@RequestParam("facultyIndex") int facultyIndex,
			@RequestParam("facultySearch") String facultySearch) {
		
		// get all Sections for this course
		List<Enroll> enrolls = enrollService.findAllBySectionIDBatchOfTenAndSearch(sectionID, studentIndex, studentSearch);
		List<Teach> teachs = teachService.findAllBySectionIDBatchOfTenAndSearch(sectionID, facultyIndex, facultySearch);
		

		theModel.addAttribute("enrolls", enrolls);
		theModel.addAttribute("teachs", teachs);
		theModel.addAttribute("sectionID", sectionID);
		theModel.addAttribute("courseID", courseID);
		
		theModel.addAttribute("studentIndex", studentIndex);
		theModel.addAttribute("studentSearch", studentSearch);
		theModel.addAttribute("facultyIndex", facultyIndex);
		theModel.addAttribute("facultySearch", facultySearch);
		
		return "/admin-home/section-management";
	}
	
	@GetMapping("/enrollstudent")
	public String showEnrollStudentPage(@RequestParam("sectionID") int theSectionID, Model theModel) {
		// create model attribute to bind form data
		
		Enroll theEnroll = new Enroll();
		Section theSection = sectionService.findById(theSectionID);
		List<User> theStudents = userService.findAllStudentNotEnrollInSection(theSectionID);
		Course theCourse = courseService.findById(theSection.getCourseID());
			
		theModel.addAttribute("enroll", theEnroll);
		theModel.addAttribute("section", theSection);
		theModel.addAttribute("users", theStudents);
		theModel.addAttribute("course", theCourse);
		
		return "/admin-home/enroll-student";
	}
	
	@GetMapping("/saveenroll")
	public String processEnrollStudent(@RequestParam("sectionID") int theSectionID, 
			@RequestParam("userID") int theStudentID,
			@RequestParam("courseID") int theCourseID) {
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		
		Enroll theEnroll = new Enroll(theStudentID,theSectionID, timestamp.toString(), '-');
		
		// save Section
		enrollService.save(theEnroll);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/coursedirectory/sections/management?sectionID="+theSectionID+"&courseID="+theCourseID+"&studentIndex=0&studentSearch=";
	}
	
	@GetMapping("/updateenroll")
	public String showUpdateForm(@RequestParam("sectionID") int theSectionID, @RequestParam("userID") int theStudentID, Model theModel) {
		Enroll theEnroll = enrollService.findById(theSectionID, theStudentID);
		theModel.addAttribute("section", sectionService.findById(theSectionID));
		theModel.addAttribute("enroll", theEnroll);
		return "/admin-home/update-section";
	}
	
	@GetMapping("/deleteenroll")
	public String processUnenrollStudent(@RequestParam("sectionID") int theSectionID, 
			@RequestParam("userID") int theStudentID,
			@RequestParam("courseID") int theCourseID) {
		enrollService.deleteById(theSectionID, theStudentID);
		return "redirect:/adminhome/coursedirectory/sections/management?sectionID="+theSectionID+"&courseID="+theCourseID+"&studentIndex=0&studentSearch=";
	}
	
	@GetMapping("/assignfaculty")
	public String showAssignFacultyPage(@RequestParam("sectionID") int theSectionID, Model theModel) {
		// create model attribute to bind form data
		
		Teach theTeach = new Teach();
		Section theSection = sectionService.findById(theSectionID);
		List<User> theFaculties = userService.findAllFacultyNotAssignInSection(theSectionID);
		Course theCourse = courseService.findById(theSection.getCourseID());
			
		theModel.addAttribute("teach", theTeach);
		theModel.addAttribute("section", theSection);
		theModel.addAttribute("users", theFaculties);
		theModel.addAttribute("course", theCourse);
		
		return "/admin-home/assign-faculty";
	}
	
	@GetMapping("/saveteach")
	public String processAssignFaculty(@RequestParam("sectionID") int theSectionID, 
			@RequestParam("userID") int theFacultyID, 
			@RequestParam("courseID") int theCourseID) {
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		
		Teach theTeach = new Teach(theFacultyID,theSectionID, timestamp.toString());
		
		// save Section
		teachService.save(theTeach);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/adminhome/coursedirectory/sections/management?sectionID="+theSectionID+"&courseID="+theCourseID+"&studentIndex=0&studentSearch=";
	}
	
	@GetMapping("/deleteteach")
	public String processUnassignFaculty(@RequestParam("sectionID") int theSectionID, 
			@RequestParam("userID") int theFacultyID,
			@RequestParam("courseID") int theCourseID) {
		teachService.deleteById(theSectionID, theFacultyID);
		return "redirect:/adminhome/coursedirectory/sections/management?sectionID="+theSectionID+"&courseID="+theCourseID+"&studentIndex=0&studentSearch=";
	}
}
