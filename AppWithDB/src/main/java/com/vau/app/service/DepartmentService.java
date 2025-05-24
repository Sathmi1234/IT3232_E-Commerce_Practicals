package com.vau.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.vau.app.model.Department;
import com.vau.app.repo.DepartmentRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;
	
	public List<Department> getDeps(){
		return repo.findAll();
	}
	
	public Department getDepwithId(String id ) {
		if(repo.findById(id).isEmpty()) {
			return null;
		}
		return repo.findById(id).get();
	}
	
	public String addDep(Department department) {
		if(repo.findById(department.getId()).isEmpty()) {
			repo.save(department);
			return "New Department Added";			
		}
		return null;
			
	}
	
	public String deleteDep(String id) {
		if(repo.findById(id).isEmpty()) {
			return null;
		}
		repo.deleteById(id);
		return "Department removed";
		
	}
	
	public String updateDep(String id, Department department) {
		if(repo.findById(id).isEmpty()) {
			return null;
		}
		repo.save(department);
		return "Department updated";
	}
}

