package com.vau.app.model.Exercise;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Session {
	@Id
	@Column(name="Session_id")
	private String id;
	private Date date;
	private String description;
	private String name;
	private Time time;
	
	@ManyToOne
	private Workshop workshop;
	
	@ManyToMany
	@JoinTable(name="under_graduate_sessions",
	joinColumns = @JoinColumn(name="undergraduate_id"),
	inverseJoinColumns = @JoinColumn(name="session_id"))
	private List<UnderGraduate> undergraduates;
	
	@ManyToMany
	@JoinTable(name="post_graduate_sessions",
	joinColumns = @JoinColumn(name="postgraduate_id"),
	inverseJoinColumns = @JoinColumn(name="session_id"))
	private List<PostGraduate> postgraduates;
	
	@ManyToMany
	@JoinTable(name="presenter_sessions",
	joinColumns = @JoinColumn(name="presenter_id"),
	inverseJoinColumns = @JoinColumn(name="session_id"))
	private List<Presenter> presenters;
}
