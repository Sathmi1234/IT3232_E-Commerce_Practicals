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

import com.vau.app.model.Project;
import com.vau.app.repo.ProjectRepo;

@RestController
@RequestMapping("/pro")
public class ProjectController {

	@Autowired
	private ProjectRepo repo;
	
	@GetMapping("/")
	public List<Project> getPros(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Project getProwithId(@PathVariable("id") String id ) {
		return repo.findById(id).get();
	}
	
	@PostMapping
	public String addPro(@RequestBody Project project){
		repo.save(project);
		return "New Project Added";
	}
	
	@DeleteMapping("/{id}")
	public String deletePro(@PathVariable("id") String id){
		if(!repo.findById(id).isEmpty()) {
			repo.deleteById(id);
			return "Project removed";
		}
		return "Couldn't Find Project";
		
	}
	
	@PutMapping("/{id}")
	public String updatePro(@PathVariable("id") String id,@RequestBody Project project){
		if(!repo.findById(id).isEmpty()) {
			repo.save(project);
			return "Project updated";
		}
		return "Couldn't Find Project";
	}

}
