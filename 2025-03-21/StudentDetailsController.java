package lk.ac.vau.fas.ict.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class StudentDetailsController {
	@GetMapping("/details")
	public String studentDetails() {
		String name = "Name: Sathmi";
		String age = "Age: 23";
		String regno = "Reg. No: 2020ict117";
		String course = "Course: IT";
		
		return name + "<br>" + age + "<br>" + regno+ "<br>" + course;
	}
}
