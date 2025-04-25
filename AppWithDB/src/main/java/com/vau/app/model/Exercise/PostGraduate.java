package com.vau.app.model.Exercise;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class PostGraduate extends Person{

	@Id
	@Column(name="PG_id")
	private String id;
	private String institute;
	private String research_interest;
	private String second_degree;
	
	@ManyToMany(mappedBy = "postgraduates")
	private List<Session> sessions;
}
