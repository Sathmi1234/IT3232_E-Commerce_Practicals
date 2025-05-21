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

import com.vau.app.model.Insurance;
import com.vau.app.repo.InsuranceRepo;

@RestController
@RequestMapping("/ins")
public class InsuranceController {

	@Autowired
	private InsuranceRepo repo;
	
	@GetMapping("/")
	public List<Insurance> getIns(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Insurance getInswithId(@PathVariable("id") String id ) {
		return repo.findById(id).get();
	}
	
	@PostMapping
	public String addIns(@RequestBody Insurance insurance){
		repo.save(insurance);
		return "New Insurance Added";
	}
	
	@DeleteMapping("/{id}")
	public String deleteIns(@PathVariable("id") String id){
		if(!repo.findById(id).isEmpty()) {
			repo.deleteById(id);
			return "Insurance removed";
		}
		return "Couldn't Find Insurance";
		
	}
	
	@PutMapping("/{id}")
	public String updateIns(@PathVariable("id") String id,@RequestBody Insurance insurance){
		if(!repo.findById(id).isEmpty()) {
			repo.save(insurance);
			return "Insurance updated";
		}
		return "Couldn't Find Insurance";
	}

}
