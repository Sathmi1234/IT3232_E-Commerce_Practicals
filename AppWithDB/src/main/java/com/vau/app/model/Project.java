package com.vau.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private String projectId;
	
	@Column(name="Project_Name")
	private String name;
	
	private long totalCost;
	
	@ManyToMany
	@JoinTable(name="project_assignments",
	joinColumns = @JoinColumn(name="empid"),
	inverseJoinColumns = @JoinColumn(name="pro_id"))
	private List<Employee> employees;
}
