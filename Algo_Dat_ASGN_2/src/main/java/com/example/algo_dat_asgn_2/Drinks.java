package com.example.algo_dat_asgn_2;

import java.util.ArrayList;
import java.util.List;

public class Drinks extends Ingredients {
    private String name;
    private String countryOfOrigin;
    private String dDescription;
    private double abv;

    private List<Ingredients> ingredients = new ArrayList<>();
    private List<Recipes> recipes = new ArrayList<>();

    // Constructor
    public Drinks(String iName, String description, String name, String countryOfOrigin, String dDescription, double abv) {
        super(iName, description, abv); // Include abv in the call to the superclass constructor
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.dDescription = dDescription;
        this.abv = abv;
    }

    // Getters and Setters
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

    public String getdDescription() {
        return dDescription;
    }

    public void setdDescription(String dDescription) {
        this.dDescription = dDescription;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    // Manage Ingredients and Recipes
    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredients ingredient) {
        ingredients.add(ingredient);
    }

    public List<Recipes> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipes recipe) {
        recipes.add(recipe);
    }
}
