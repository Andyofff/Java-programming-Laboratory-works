package com.example.h2dbmemory.db;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Person {
    @jakarta.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "person_name")
    private String name;

    public Person() {

    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
