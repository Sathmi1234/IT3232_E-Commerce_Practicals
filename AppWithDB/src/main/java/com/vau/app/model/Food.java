package com.vau.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Food {
    @Id
    private Long id;

    private String name;

    private double price;

    private double weight;
    
    @ManyToMany(mappedBy = "foods")
    private List<DailyMenu> dailyMenus;
}
