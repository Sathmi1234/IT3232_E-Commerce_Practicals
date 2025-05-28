package com.vau.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public InsuranceService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Insurance>> getDepts(){
		return new ResponseEntity<List<Insurance>>(service.getDeps(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Insurance> getDeptwithId(@PathVariable String id){
		if(service.getDepwithId(id)==null) {
			return new ResponseEntity<Insurance>(service.getDepwithId(id),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Insurance>(service.getDepwithId(id),HttpStatus.OK);
	}
	
	
	@PostMapping("/")
	public String addDep(@RequestBody Insurance insurance){
			return new String(service.addDep(insurance));
	}
	
	@DeleteMapping("/{id}")
	public String deleteDep(@PathVariable("id") String id){
		return new String(service.deleteDep(id));
	}
	
	@PutMapping("/{id}")
	public String updateDep(@PathVariable("id") String id,@RequestBody Insurance insurance){
		return new String(service.updateDep(id,insurance));
	}
	

}
