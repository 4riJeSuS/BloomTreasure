package com.example.bloomtreasure;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_itord;

    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unit_price;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    private OrderSale order;

    public ItemOrder() {}

    public Long getId_itord() {
        return id_itord;
    }
    public void setId_itord(Long id_itord) {
        this.id_itord = id_itord;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public OrderSale getId_order() {
        return order;
    }
    public void setId_order(OrderSale id_order) {
        this.order = id_order;
    }
}
