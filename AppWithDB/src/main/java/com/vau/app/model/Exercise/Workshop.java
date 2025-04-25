package com.vau.app.model.Exercise;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Workshop {
	@Id
	@Column(name="Workshop_id")
	private int id;
	private String description;
	private Date end_date;
	private String name;
	private Date start_date;
	
	@OneToMany(mappedBy="workshop")
	private List<Session> sessions;
	
}
