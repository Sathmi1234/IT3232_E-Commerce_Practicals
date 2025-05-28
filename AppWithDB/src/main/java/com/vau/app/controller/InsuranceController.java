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
import com.vau.app.service.InsuranceService;

@RestController
@RequestMapping("/ins")
public class InsuranceController {

	@Autowired
	public InsuranceService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Insurance>> getDepts(){
		return new ResponseEntity<List<Insurance>>(service.getIns(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Insurance> getDeptwithId(@PathVariable String id){
		if(service.getInswithId(id)==null) {
			return new ResponseEntity<Insurance>(service.getInswithId(id),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Insurance>(service.getInswithId(id),HttpStatus.OK);
	}
	
	
	@PostMapping("/")
	public String addDep(@RequestBody Insurance insurance){
			return new String(service.addIns(insurance));
	}
	
	@DeleteMapping("/{id}")
	public String deleteDep(@PathVariable("id") String id){
		return new String(service.deleteIns(id));
	}
	
	@PutMapping("/{id}")
	public String updateDep(@PathVariable("id") String id,@RequestBody Insurance insurance){
		return new String(service.updateIns(id,insurance));
	}
	

}
