package com.example.bloomtreasure;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class OrderSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_order;

    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total_price;
    @Column(nullable = false, length = 30)
    private String state;
    @Column(nullable = false, length = 30)
    private String payment_method;

    @ManyToOne
    @JoinColumn(name = "id_clt", nullable = false)
    private Client client;

    public OrderSale() {}

    public Long getId_order() {
        return id_order;
    }
    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }
    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getPayment_method() {
        return payment_method;
    }
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client id_clt) {
        this.client = id_clt;
    }
}
