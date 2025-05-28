package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lk.ac.vau.fas.ict.model.Employee;
import lk.ac.vau.fas.ict.repo.EmployeeRepo;

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
		if(repo.findById(employee.getId()).isEmpty()) {
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
}
