package lk.ac.vau.fas.ict.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
	@GetMapping("/msg")
	public String myMsg() {
		return "Hello Springboot";
	}
	
	@GetMapping("/name")
	public String myName() {
		return "My name is Springboot";
	}

}
