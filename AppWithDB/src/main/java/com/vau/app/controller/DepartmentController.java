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

import com.vau.app.model.Department;
import com.vau.app.repo.DepartmentRepo;


@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentRepo repo;
	
	@GetMapping("/")
	public List<Department> getDeps(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Department getDepwithId(@PathVariable("id") String id ) {
		return repo.findById(id).get();
	}
	
	@PostMapping
	public String addDept(@RequestBody Department department){
		repo.save(department);
		return "New Department Added";
	}
	
	@DeleteMapping("/{id}")
	public String deleteDept(@PathVariable("id") String id){
		if(!repo.findById(id).isEmpty()) {
			repo.deleteById(id);
			return "Department removed";
		}
		return "Couldn't Find Department";
		
	}
	
	@PutMapping("/{id}")
	public String updateDept(@PathVariable("id") String id,@RequestBody Department department){
		if(!repo.findById(id).isEmpty()) {
			repo.save(department);
			return "Department updated";
		}
		return "Couldn't Find Department";
	}
}
