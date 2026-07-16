package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.Course;
import com.Service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	 private final CourseService courseService;

	    public CourseController(CourseService courseService) {
	        this.courseService = courseService;
	    }
	    @GetMapping({"", "/", "/add"})
	    public String showForm(Model model) {
	        model.addAttribute("course", new Course());
	        return "add-course";
	    }
	    @PostMapping("/save")
	    public String saveCourse(@ModelAttribute Course course,@RequestParam("imageFile") MultipartFile imageFile) {
	    	courseService.saveCourse(course, imageFile);
	    	return "redirect:/courses/list";
	    }
	    @GetMapping("/list")
	    public String listCourse(Model model) {
	    	model.addAttribute("courses",courseService.getAllCourse());
	    	return "Course-list";
	    }
}
