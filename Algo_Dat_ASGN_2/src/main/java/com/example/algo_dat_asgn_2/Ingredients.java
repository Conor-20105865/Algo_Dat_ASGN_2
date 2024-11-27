package com.example.algo_dat_asgn_2;

public class Ingredients {
    private String iName;
    private String description;
    private double abv;

    // Constructor
    public Ingredients(String iName, String description, double abv) {
        this.iName = iName;
        this.description = description;
        this.abv = abv;
    }

    // Getters and Setters
    public String getName() {
        return iName;
    }

    public void setName(String iName) {
        this.iName = iName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }
}
