package com.myexpensetracker.ExpenseTracker.model;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;



public class Expense {
    private String description;
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
}
