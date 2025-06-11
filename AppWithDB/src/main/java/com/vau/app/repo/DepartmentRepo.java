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
	
	//display departments along with the number of employees working there
	/*
	 * dept_name:HR
	 * no_emp:5
	 * 
	 * 	*******USING BOTH TABLES
	 * 	select d.dep_name,count(e.emp_id) As no_emp
	 *	from Employee e, Department d
	 *	WHERE d.dep_id = e.department_dep_id
	 *	GROUP BY d.dep_id;
	 */
	
	//	*******USING ONLY DEPARTMENT MODEL
	@Query("SELECT count(*) "
			+ "FROM Department d "
			+ "JOIN d.employees "
			+ "WHERE d.id = ?1")
	public int getEmpCountbyDep(String depid);
	
}
