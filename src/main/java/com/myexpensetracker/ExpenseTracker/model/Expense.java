package com.myexpensetracker.ExpenseTracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;


@Entity

public class Expense {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String description;
    @Column
    private BigDecimal price;


    @Override
    public String toString() {
        return "Expense{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public Expense(){

    }
    public Expense(String description, BigDecimal price){
        this.description = description;
        this.price = price;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
