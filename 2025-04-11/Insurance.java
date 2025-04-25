package com.vau.app.day6.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Insurance {
	@Id
	@Column(name="Insurance_Id")
	private String insId;
	private int years;
	
	@OneToOne
	private Employee employee;

}
