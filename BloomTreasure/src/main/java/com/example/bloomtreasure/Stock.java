package com.example.bloomtreasure;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_stk;

    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false, length = 30)
    private String state;

    public Stock() {}

    public Long getId_stock() {
        return id_stk;
    }
    public void setId_stock(Long id_stock) {
        this.id_stk = id_stock;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
