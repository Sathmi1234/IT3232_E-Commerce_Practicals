package com.vau.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Canteen {
    @Id
    private Long id;

    private String location;

    @ManyToMany(mappedBy = "canteens")
    private List<Employee> employees;

    @OneToMany(mappedBy = "canteen")
    private List<DailyMenu> dailyMenus;
}
