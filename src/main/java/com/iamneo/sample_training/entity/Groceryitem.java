package com.iamneo.sample_training.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Groceryitem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long GroceryitemId;
    private String name;
    private String quantity;
    private Double Price;

    public Long getGroceryitemId() {
        return GroceryitemId;
    }
    public void setGroceryitemId(Long groceryitemId) {
        GroceryitemId = groceryitemId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return Price;
    }
    public void setPrice(Double price) {
        Price = price;
    }

    public Groceryitem(Long groceryitemId, String name, String quantity, Double price) {
        GroceryitemId = groceryitemId;
        this.name = name;
        this.quantity = quantity;
        Price = price;
    }
    
    public Groceryitem() {
    }
}