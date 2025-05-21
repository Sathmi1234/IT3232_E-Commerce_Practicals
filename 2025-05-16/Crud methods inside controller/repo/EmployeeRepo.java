package com.vau.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vau.app.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String>{

}
