package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lk.ac.vau.fas.ict.model.Insurance;
import lk.ac.vau.fas.ict.repo.InsuranceRepo;

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
		if(repo.findById(insurance.getId()).isEmpty()) {
			repo.save(department);
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
