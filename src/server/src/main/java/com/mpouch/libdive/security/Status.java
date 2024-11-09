package com.mpouch.libdive.security;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    protected Status() {}

    public Status(String name) {
        this.name = name;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
