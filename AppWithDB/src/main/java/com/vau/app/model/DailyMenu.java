package com.vau.app.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DailyMenu {
    @Id
    private Long id;

    private Date date;

    private Canteen canteen;

    private List<Food> foods;
}
