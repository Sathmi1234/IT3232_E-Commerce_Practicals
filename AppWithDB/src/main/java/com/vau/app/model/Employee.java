package com.vau.app.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Employee extends Person {
    private String jobPosition;
 
    private List<Canteen> canteens;
}
