package com.vau.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vau.app.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String>{

}
