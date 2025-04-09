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
	
}

