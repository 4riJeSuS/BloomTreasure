package com.example.bloomtreasure;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rct;

    @Column(nullable = false)
    private LocalDate emi_date;
    @Column(nullable = false, length = 1000)
    private String receipt_info;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    private OrderSale order;

    public Receipt() {}

    public Long getId_rct() {
        return id_rct;
    }
    public void setId_rct(Long id_rct) {
        this.id_rct = id_rct;
    }

    public LocalDate getEmi_date() {
        return emi_date;
    }
    public void setEmi_date(LocalDate emi_date) {
        this.emi_date = emi_date;
    }

    public String getReceipt_info() {
        return receipt_info;
    }
    public void setReceipt_info(String receipt_info) {
        this.receipt_info = receipt_info;
    }

    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderSale getOrder() {
        return order;
    }
    public void setOrder(OrderSale order) {
        this.order = order;
    }
}
