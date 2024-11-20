package com.example.algo_dat_asgn_2;

public class Recipes extends Ingredients {

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

    public Recipes(String iName, String description, int amount, String recipeGuide) {
        super(iName, description);
        this.amount = amount;
        this.recipeGuide = recipeGuide;
    }
}
