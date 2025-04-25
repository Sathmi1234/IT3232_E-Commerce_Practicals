package com.vau.app.day6.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@Column(name="dep_id")
	private String id;
	
	@Column(nullable=false)
	private String depName;
	
	private Date established;
		
	@OneToMany(mappedBy="department")
	private List<Employee> employees;
	
}
