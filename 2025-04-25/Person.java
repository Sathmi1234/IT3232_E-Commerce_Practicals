package com.vau.app.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	private String name;
	private String age;
	private String gender;
}
