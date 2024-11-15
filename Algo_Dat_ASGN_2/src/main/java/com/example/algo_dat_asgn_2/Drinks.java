package com.example.algo_dat_asgn_2;

public class Drinks {
    String name;
    String countryOfOrigin;
    String description;
    double abv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
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

    public Drinks(String name, String countryOfOrigin, String description, double abv) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.description = description;
        this.abv = abv;
    }
}
