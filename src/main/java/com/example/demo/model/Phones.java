package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Phones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String modelName;
    private int price;
    private boolean isUsed;

    Phones(int id, String modelName, int price, boolean isUsed) {
        this.id = id;
        this.modelName = modelName;
        this.price = price;
        this.isUsed = isUsed;
    }

    Phones() {

    }

    public int getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public int getPrice() {
        return price;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

}
