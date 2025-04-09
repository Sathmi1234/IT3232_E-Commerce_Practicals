package lk.ac.vau.fas.ict.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Course;

@RestController
@RequestMapping("/Course")
public class NewCourseController extends ParentController<Integer, Course>{	
	
	public NewCourseController() {
		Course cplus = new Course("C++", 123, "Introduction to Programming", 2.5, 3);
		Course html = new Course("HTML++", 456, "Introduction to Web Programming", 1.5, 1);
		Course reactnative = new Course("React Native", 789, "Introduction to Mobile Applications", 3.5, 2);
				
		getAll().put(cplus.getCode(),cplus);
		getAll().put(html.getCode(),html);
		getAll().put(reactnative.getCode(),reactnative);
	}
		
}
