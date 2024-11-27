package com.example.algo_dat_asgn_2;

public class Recipes extends Ingredients {

    private int amount; // in milliliters or grams
    private String recipeGuide;

    // Constructor
    public Recipes(String iName, String description, double abv, int amount, String recipeGuide) {
        super(iName, description, abv); // Include abv in the call to the superclass constructor
        this.amount = amount;
        this.recipeGuide = recipeGuide;
    }

    // Getters and Setters
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRecipeGuide() {
        return recipeGuide;
    }

    public void setRecipeGuide(String recipeGuide) {
        this.recipeGuide = recipeGuide;
    }

    // Add ingredients to the recipe
    public void addIngredient(Ingredients ingredient, int quantity) {
        // Add implementation to handle adding ingredients to the recipe
    }
}
