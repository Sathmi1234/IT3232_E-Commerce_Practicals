package lk.ac.vau.fas.ict.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/Student")
public class StudentWithParentController extends ParentController<String, Student>{
	public StudentWithParentController() {
		Student Bob = new Student("Bob",23,"IT","2020ict150",3.3);
		Student Alice = new Student("Alice",22,"IT","2020ict200",3.9);
		Student John = new Student("John",25,"IT","2020ict250",2.5);
		
		getAll().put(Bob.getRegNo(),Bob);
		getAll().put(Alice.getRegNo(),Alice);
		getAll().put(John.getRegNo(),John);
	}
}
