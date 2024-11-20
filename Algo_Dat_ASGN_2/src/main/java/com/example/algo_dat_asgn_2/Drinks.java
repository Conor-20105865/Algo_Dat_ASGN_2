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

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }


    public void addIngredient(Ingredients ingredient) {
    }

    public void addRecipe(Recipes recipe) {
    }

    public String getdDescription() {
        return dDescription;
    }

    public void setdDescription(String dDescription) {
        this.dDescription = dDescription;
    }
}
