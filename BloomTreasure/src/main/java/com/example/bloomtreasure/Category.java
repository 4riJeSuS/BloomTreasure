package com.example.bloomtreasure;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cat;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 200)
    private String description;

    public Category() {}

    public Long getId_cat() {
        return id_cat;
    }
    public void setId_cat(Long id_cat) {
        this.id_cat = id_cat;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
