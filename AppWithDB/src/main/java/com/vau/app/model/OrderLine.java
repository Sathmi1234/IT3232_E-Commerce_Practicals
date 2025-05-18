package com.vau.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderLine {
    @Id
    private Long id;
    
    private int quantity;

    private FoodOrder order;

    private Food food;
}
