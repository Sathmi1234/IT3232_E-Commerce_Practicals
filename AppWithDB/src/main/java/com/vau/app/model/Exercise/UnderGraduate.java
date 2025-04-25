package com.vau.app.model.Exercise;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class UnderGraduate extends Person{
	
	@Id
	@Column(name="UG_id")
	private String id;
	private String degree;
	private String university;
	

	@ManyToMany(mappedBy = "undergraduates")
	private List<Session> sessions;
}
