package com.vau.app.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Student extends Person {
    private String degree;

    private List<FoodOrder> orders;
}
