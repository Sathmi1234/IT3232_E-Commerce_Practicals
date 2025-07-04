package com.vau.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.vau.app.model.Department;
import com.vau.app.model.ViewDepartment;
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
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.findById(id).get();
	}
	
	public String addDep(Department department) {
		if(repo.findById(department.getId()).isEmpty()) {
			repo.save(department);
			return "New Department Added";			
		}
		throw new DuplicateKeyException("Department already Exists");
			
	}
	
	public String deleteDep(String id) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		repo.deleteById(id);
		return "Department removed";
		
	}
	
	public String updateDep(String id, Department department) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		repo.save(department);
		return "Department updated";
	}
	
	public List<String> getDepartmentNames() {
		if(repo.getDeptNames().isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.getDeptNames();
	}
	
	public List<Department> searchName(String name) {
		if(repo.getDeptByName(name).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.getDeptByName(name);
	}
	
	public int empCount(String depid) {
		if(repo.findById(depid).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.getEmpCountbyDep(depid);
	}
	
	public ViewDepartment empCountFromView(String depid) {
		if(repo.findById(depid).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		
		Department department = repo.findById(depid).get();
		ViewDepartment  viewdepartment=new ViewDepartment(department.getId(),department.getDepName(),
				department.getEstablished(),repo.getEmpCountbyDep(depid));
		return viewdepartment;
	}
	
	public List<ViewDepartment> empCountOfAllFromView() {
	    List<Department> departments = repo.findAll();
	    int length = departments.size();
	    List<ViewDepartment> viewdepartments = new ArrayList<>();
	    for (int i = 0; i < length; i++) {
	        ViewDepartment vd = new ViewDepartment(
	            departments.get(i).getId(),
	            departments.get(i).getDepName(),
	            departments.get(i).getEstablished(),
	            empCount(departments.get(i).getId())
	        );
	        viewdepartments.add(vd);
	    }
	    return viewdepartments;
	}


}
