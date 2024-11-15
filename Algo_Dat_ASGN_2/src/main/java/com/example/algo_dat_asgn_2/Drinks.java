package com.example.algo_dat_asgn_2;

public class Drinks extends Ingredients{
    String name;
    String countryOfOrigin;
    String dDescription;
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
        return dDescription;
    }

    public void setDescription(String dDescription) {
        this.dDescription = dDescription;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public Drinks(String iName, String description, String name, String countryOfOrigin, String dDescription, double abv) {
        super(iName, description);
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.dDescription = dDescription;
        this.abv = abv;
    }
}
