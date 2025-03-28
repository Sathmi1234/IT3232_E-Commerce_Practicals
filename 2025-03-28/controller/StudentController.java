package lk.ac.vau.fas.ict.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class StudentController {
	Student s1 = new Student("Bob",23,"IT","2020ict150",3.3);
	Student s2 = new Student("Alice",22,"IT","2020ict200",3.9);
	Student s3 = new Student("John",25,"IT","2020ict250",2.5);
	
	List<Student> students = new ArrayList<Student>();
	
	@GetMapping("/studetails")
	public Student getStudentDetails() {
		return s1;
	}
	
	@GetMapping("/allstudetails")
	public List<Student> getAllStudentDetails() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
		return students;
	}


}
