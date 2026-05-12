package com.example.bloomtreasure;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prod;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 200)
    private String description;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "id_cat", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_stk", nullable = false)
    private Stock stock;

    @ManyToMany
    @JoinTable(
            name = "REFERENCE", // Nome da tabela no MySQL
            joinColumns = @JoinColumn(name = "id_prod"), // Coluna que liga ao Produto
            inverseJoinColumns = @JoinColumn(name = "id_itord") // Coluna que liga ao Item
    )
    private List<ItemOrder> items;

    public Product() {}

    public Stock getStock() {
        return stock;
    }
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId_prod() {
        return id_prod;
    }
    public void setId_prod(Long id_prod) {
        this.id_prod = id_prod;
    }

    public List<ItemOrder> getItems() {
        return items;
    }
    public void setItems(List<ItemOrder> items) {
        this.items = items;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
