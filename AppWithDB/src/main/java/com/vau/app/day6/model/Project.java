package com.vau.app.day6.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private String projectId;
	
	@Column(name="Project_Name")
	private String name;
	
	@ManyToMany
	private List<Employee> employees;
}
