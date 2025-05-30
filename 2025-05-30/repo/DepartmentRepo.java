package com.vau.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vau.app.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String>{

	//JPQL
	@Query("Select depName from Department")
	public List<String> getDeptNames();
	
	@Query("SELECT d FROM Department d WHERE d.depName LIKE %?1%")
	public List<Department> getDeptByName(String name);
	
	
}
