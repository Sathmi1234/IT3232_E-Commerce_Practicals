package lk.ac.vau.fas.ict.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class SendDataController {
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age) {
		return "My age is " + age;
	}
	@GetMapping("/information/{ag},{nm}")
	public String MyDetails(@PathVariable("ag") int age,@PathVariable("nm") String name) {
		return "My name is "+name+"\nMy age is "+age;
	}
}
