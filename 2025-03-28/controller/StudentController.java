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
	
	public StudentController() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
	}
	
	@GetMapping("/studetails")
	public Student getStudentDetails() {
		return s1;
	}
	
	@GetMapping("/allstudetails")
	public List<Student> getAllStudentDetails() {
		return students;
	}
	
	@GetMapping("/getstudentbyReg/{reg}")
	public Student getstudentbyReg(@PathVariable("reg") String regNo) {
		for(Student student:students) {
			if(student.getRegNo().equals(regNo)) {
				return student;
			}
		}
		return null;
	}

	//find the students who's age is between 20 and 23
	List<Student> studentbetween20and30 = new ArrayList<Student>();
	@GetMapping("/studentbetween20and30")
	public List<Student> getStudentBetween() {
		for(Student student:students) {
			if(20<student.getAge() && student.getAge()<30 ) {
				studentbetween20and30.add(student);
			}
		}
		return studentbetween20and30;
	}

	//sort students by their gpa
	@GetMapping("/sortbyGPA")
	public List<Student> getSortedStudentbyGPA(){
		students.sort(Comparator.comparing(Student::getGpa));
		return students;
	}

	//create crud operations for students
	//create
	@GetMapping("/addStudent/{nm},{ag},{crs},{reg},{gp}")
	public List<Student> addStudent(@PathVariable("nm") String name,@PathVariable("ag") int age,@PathVariable("crs") String course,@PathVariable("reg") String regNo,@PathVariable("gp") double gpa){
		Student newstu = new Student(name,age,course,regNo,gpa);
		students.add(newstu);
		return students;
	}
	
}
