package com.example.algo_dat_asgn_2;

public class Recipes extends Drinks {

    private int amount; // in millileters or grams
    private String recipeGuide;

    //Getters and Setters
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

    public Recipes(String name, String countryOfOrigin, String dDescription, double abv, int amount, String recipeGuide) {
        super(name, countryOfOrigin, dDescription, abv);
        this.amount = amount;
        this.recipeGuide = recipeGuide;
    }

    public void addIngredient(Ingredients ingredient, int quantity) {
    }
}
