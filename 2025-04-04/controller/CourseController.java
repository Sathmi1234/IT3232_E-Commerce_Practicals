package lk.ac.vau.fas.ict.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Course;
import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/appCourse")
public class CourseController {
	private Map<Integer, Course> courses = new HashMap<Integer,Course>();
	
	@PostMapping("/add")
	public String addCourse(@RequestBody Course course) {
		courses.put(course.getCode(), course);
		return "New Course Added";
	}
	
	@GetMapping("/allCourses")
	public Map<Integer,Course> getAllCourses() {
		return courses;
	}
	
	@GetMapping("/coursebyCode/{c}")
	public Course getCourseByCode(@PathVariable("c") int code){
		return courses.get(code);
	}
	
	@DeleteMapping("/delCourse/{c}")
	public String deleCourse(@PathVariable("c") int code){
		if(courses.get(code) != null) {
			courses.remove(code);
			return "Course removed";
		}
		
		return "Coudn't find Course";
	}
	@PutMapping("/updateCourse/{cd}")
	public String updateCourse(@PathVariable("cd") int code,@RequestBody Course course){
		if(courses.get(code) != null) {
			courses.put(course.getCode(),course);
			return "Course Updated";			
		}
		return "Coudn't find Course";
	}
	
}
