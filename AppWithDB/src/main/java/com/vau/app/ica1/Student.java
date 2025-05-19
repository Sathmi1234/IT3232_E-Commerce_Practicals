package com.vau.app.ica1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

//@Entity
public class Student extends Person {
    private String degree;

    @OneToMany(mappedBy = "student")
    private List<FoodOrder> orders;
}
