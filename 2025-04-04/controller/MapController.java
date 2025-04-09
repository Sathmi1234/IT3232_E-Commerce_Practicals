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

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class MapController {
	Student Bob = new Student("Bob",23,"IT","2020ict150",3.3);
	Student Alice = new Student("Alice",22,"IT","2020ict200",3.9);
	Student John = new Student("John",25,"IT","2020ict250",2.5);
	
	private Map<String,Student> mstudents = new HashMap<String,Student>();
	
	public MapController() {
		mstudents.put(Bob.getRegNo(),Bob);
		mstudents.put(Alice.getRegNo(),Alice);
		mstudents.put(John.getRegNo(),John);
	}
	
    	@GetMapping("/mapstudent/{id}")
	public Student getStudentMap(@PathVariable("id") String regno) {
		return mstudents.get(regno);
	}
	
	@GetMapping("/mapstudentAll")
	public Map<String, Student> getAllStudentsMap() {
		return mstudents;
	}
    	
    //Add Student
	@PostMapping("/add")
	public String addStudentMap(@RequestBody Student student){
		mstudents.put(student.getRegNo(), student);
		return "New Student Added";
	}
    
    //Delete Student
	@DeleteMapping("/delStu/{reg}")
	public String deleStudentMap(@PathVariable("reg") String regNo){
		if(mstudents.get(regNo) != null) {
			mstudents.remove(regNo);
			return "Student removed";
		}
		
		return "Coudn't find student";
	}

    	//Update Student
	@PutMapping("/update/{reg}")
	public String updateStudentMap(@PathVariable("reg") String regNo,@RequestBody Student student){
		if(mstudents.get(regNo) != null) {
			mstudents.put(student.getRegNo(), student);
			return "Student Updated";			
		}
		return "Coudn't find student";
	}
}

