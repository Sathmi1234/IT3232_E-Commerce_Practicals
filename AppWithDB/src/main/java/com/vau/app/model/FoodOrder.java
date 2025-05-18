package com.vau.app.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FoodOrder {
    @Id
    private Long id;

    private Date orderDate;

    private Student student;

    private List<OrderLine> orderLines;
}