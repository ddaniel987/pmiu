package com.example.zad7;

import java.io.Serializable;
import java.util.Random;

public class Veggie implements Serializable {
    private String name;
    private Double price;
    private Double amount;
    private Double sugary_index;

    Veggie(String name, Double price, Double amount, Double sugary_index) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.sugary_index = sugary_index;
    }

    public void randomAmount() {
        Random random = new Random();
        this.amount = random.nextDouble() * 99.0f + 1.0f;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public Double getAmount() {
        return this.amount;
    }

    public Double getSugary_index() {
        return this.sugary_index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setSugaryIndex(Double sugary) {
        this.sugary_index = sugary;
    }


}
