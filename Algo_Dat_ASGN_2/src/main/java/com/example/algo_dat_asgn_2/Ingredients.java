package com.example.algo_dat_asgn_2;

public class Ingredients extends Recipes  {
    String iName;
    String iDescription;

    //Getters and Setters
    public String getName() {
        return iName;
    }

    public void setName(String iName) {
        this.iName = iName;
    }

    public String getDescription() {
        return iDescription;
    }

    public void setDescription(String iDescription) {
        this.iDescription = iDescription;
    }


    public Ingredients(String name, String countryOfOrigin, String dDescription, double abv, int amount, String recipeGuide, String iName, String iDescription) {
        super(name, countryOfOrigin, dDescription, abv, amount, recipeGuide);
        this.iName = iName;
        this.iDescription = iDescription;
    }

}
