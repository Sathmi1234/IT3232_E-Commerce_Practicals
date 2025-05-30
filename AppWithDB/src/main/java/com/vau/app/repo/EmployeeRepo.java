package com.vau.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vau.app.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String>{
	
	//find the employees with salary range 70000 to 90000
	@Query("SELECT e FROM Employee e WHERE e.salary between %?1% AND %?2%")
	public List<Employee> searchEmpbySalRange(int a, int b);

}
