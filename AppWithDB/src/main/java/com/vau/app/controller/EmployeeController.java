package com.vau.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vau.app.model.Employee;
import com.vau.app.repo.EmployeeRepo;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;
	
	@GetMapping("/")
	public List<Employee> getEmps(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmpwithId(@PathVariable("id") String id ) {
		return repo.findById(id).get();
	}
	
	@PostMapping
	public String addEmp(@RequestBody Employee employee){
		repo.save(employee);
		return "New Employee Added";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmp(@PathVariable("id") String id){
		if(!repo.findById(id).isEmpty()) {
			repo.deleteById(id);
			return "Employee removed";
		}
		return "Couldn't Find Employee";
		
	}
	
	@PutMapping("/{id}")
	public String updateEmp(@PathVariable("id") String id,@RequestBody Employee employee){
		if(!repo.findById(id).isEmpty()) {
			repo.save(employee);
			return "Employee updated";
		}
		return "Couldn't Find Employee";
	}
}
