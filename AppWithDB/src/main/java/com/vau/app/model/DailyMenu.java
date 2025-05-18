package com.vau.app.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DailyMenu {
    @Id
    private Long id;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "canteen_id")
    private Canteen canteen;

    private List<Food> foods;
}
