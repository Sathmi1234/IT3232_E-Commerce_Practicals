package com.vau.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.vau.app.model.Insurance;
import com.vau.app.repo.InsuranceRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InsuranceService {
	@Autowired
	private InsuranceRepo repo;
	
	public List<Insurance> getIns(){
		return repo.findAll();
	}
	
	public Insurance getInswithId(String id ) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Insurance Not Found");
		}
		return repo.findById(id).get();
	}
	
	public String addIns(Insurance insurance) {
		if(repo.findById(insurance.getInsId()).isEmpty()) {
			repo.save(insurance);
			return "New Insurance Added";			
		}
		throw new DuplicateKeyException("Insurance already Exists");
		
	}
	
	public String deleteIns(String id) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Insurance Not Found");
		}
		repo.deleteById(id);
		return "Insurance removed";
	}
	
	public String updateIns(String id, Insurance insurance) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Insurance Not Found");
		}
		repo.save(insurance);
		return "Insurance updated";
	}

}
