package com.vau.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vau.app.model.Department;
import com.vau.app.repo.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;
	
	public List<Department> getDeps(){
		return repo.findAll();
	}
	
	public Department getDepwithId(String id ) {
		if(repo.findById(id).isEmpty()) {
			throw "Department Not Found";
		}
		return repo.findById(id).get();
	}
	
	public String addDep(Department department) {
		if(repo.findById(department.getId()).isEmpty()) {
			repo.save(department);
			return "New Department Added";			
		}
		throw "Department already Exists";
			
	}
	
	public String deleteDep(String id) {
		if(repo.findById(id).isEmpty()) {
			throw "Department Not Found";
		}
		repo.deleteById(id);
		return "Department removed";
		
	}
	
	public String updateDep(String id, Department department) {
		if(repo.findById(id).isEmpty()) {
			throw "Department Not Found";
		}
		repo.save(department);
		return "Department updated";
	}
}

