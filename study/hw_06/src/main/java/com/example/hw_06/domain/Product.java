package com.example.hw_06.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer price;
    private Integer quantity;
    private String category;
    private boolean onSale;

    protected Product() {

    }

    public Product(String title, Integer price, Integer quantity, String category, boolean onSale) {

        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.onSale = onSale;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void update(String title, Integer price, Integer quantity, String category, boolean onSale) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.onSale = onSale;
    }
}
