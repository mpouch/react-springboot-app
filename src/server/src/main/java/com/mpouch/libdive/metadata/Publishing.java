package com.mpouch.libdive.metadata;

import jakarta.persistence.*;

@Entity
@Table(name = "publishing")
public class Publishing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    protected Publishing() {}

    public Publishing(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
