package com.vau.app.model.Exercise;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Presenter extends Person{
	@Id
	@Column(name="Presenter_id")
	private String id;
	private String affiliation;
	private String country;
	private String job_title;

	@ManyToMany(mappedBy = "presenters")
	private List<Session> sessions;
}
