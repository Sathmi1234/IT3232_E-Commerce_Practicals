package com.vau.app.day6.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	private String empId;
	
	private String name;
	private int age;
	private double salary;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany(mappedBy = "employees")
	private List<Project> projects;
	
	@OneToOne(mappedBy="employee")
	private Insurance insurance;
}
