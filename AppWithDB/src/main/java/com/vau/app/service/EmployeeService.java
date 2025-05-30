package com.vau.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.vau.app.model.Employee;
import com.vau.app.repo.EmployeeRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	public List<Employee> getEmp(){
		return repo.findAll();
	}
	
	public Employee getEmpwithId(String id ) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Employee Not Found");
		}
		return repo.findById(id).get();
	}
	
	public String addEmp(Employee employee) {
		if(repo.findById(employee.getEmpId()).isEmpty()) {
			repo.save(employee);
			return "New Employee Added";			
		}
		throw new DuplicateKeyException("Employee already Exists");
		
	}
	
	public String deleteEmp(String id) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Employee Not Found");
		}
		repo.deleteById(id);
		return "Department removed";
		
	}
	
	public String updateEmp(String id, Employee employee) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Employee Not Found");
		}
		repo.save(employee);
		return "Employee updated";
	}
	
	public List<Employee> searchBySalary(int min, int max) {
		if(repo.searchEmpbySalRange(min,max).isEmpty()) {
			throw new EntityNotFoundException("Employee Not Found");
		}
		return repo.searchEmpbySalRange(min,max);
	}
	
	public List<Employee> searchEmpsByDep(String depId) {
		if(repo.searchByDep(depId).isEmpty()) {
			throw new EntityNotFoundException("Employee Not Found");
		}
		return repo.searchByDep(depId);
	}
}
