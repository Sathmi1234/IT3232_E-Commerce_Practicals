package com.vau.app.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodOrder {
    @Id
    private Long id;

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private List<OrderLine> orderLines;
}