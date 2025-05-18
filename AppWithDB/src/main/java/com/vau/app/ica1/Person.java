package com.vau.app.ica1;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    @Id
    private Long id;

    private String name;

    private int age;
    
    private String gender;
}
