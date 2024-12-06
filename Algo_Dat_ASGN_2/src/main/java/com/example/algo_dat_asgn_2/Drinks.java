package com.example.algo_dat_asgn_2;

public class Drinks extends Ingredients {
    private String name;
    private String countryOfOrigin;
    private String dDescription;
    private double abv;

    private DoublyLinkedList<Ingredients> ingredients = new DoublyLinkedList<>();
    private DoublyLinkedList<Recipes> recipes = new DoublyLinkedList<>();

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
    public DoublyLinkedList<Ingredients> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredients ingredient) {
        if (ingredient != null) {
            ingredients.insertAtEnd(ingredient);
        } else {
            System.err.println("Ingredient cannot be null.");
        }
    }

  //  public DoublyLinkedList<Recipes> getRecipes() {
 //       return recipes;
 //   }
//
//    public void addRecipe(Recipes recipe) {
//        if (recipe != null) {
//            recipes.insertAtEnd(recipe);
//        } else {
//            System.err.println("Recipe cannot be null.");
//        }
//    }

    // Additional Methods for Convenience
    public void printIngredients() {
        System.out.println("Ingredients:");
        if (!ingredients.isEmpty()) {
            ingredients.printList();
        } else {
            System.out.println("No ingredients added.");
        }
    }

    public void printRecipes() {
        System.out.println("Recipes:");
        if (!recipes.isEmpty()) {
            recipes.printList();
        } else {
            System.out.println("No recipes added.");
        }
    }

    // Debugging utility method
    public void printDrinkDetails() {
        System.out.println("Drink Details:");
        System.out.println("Name: " + name);
        System.out.println("Country of Origin: " + countryOfOrigin);
        System.out.println("Description: " + dDescription);
        System.out.println("ABV: " + abv);
        printIngredients();
        printRecipes();
    }
}
