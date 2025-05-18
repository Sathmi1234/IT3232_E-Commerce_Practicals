package com.vau.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Canteen {
    @Id
    private Long id;

    private String location;

    private List<Employee> employees;

    private List<DailyMenu> dailyMenus;
}
