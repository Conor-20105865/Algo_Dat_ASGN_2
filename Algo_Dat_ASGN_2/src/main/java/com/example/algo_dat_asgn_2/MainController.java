package com.example.drinkinfosystem;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainController {

    @FXML
    private ListView<Drink> drinksList;
    @FXML
    private TextField drinkNameField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField abvField;
    @FXML
    private TextField imageUrlField;
    @FXML
    private Button addDrinkButton;

    @FXML
    private TextField ingredientNameField;
    @FXML
    private TextField ingredientDescriptionField;
    @FXML
    private TextField ingredientAbvField;
    @FXML
    private TextField recipeDrinkNameField;
    @FXML
    private TextField recipeIngredientNameField;
    @FXML
    private TextField recipeQuantityField;

    private CustomHashTable<String, Drink> drinksHashTable = new CustomHashTable<>();

    @FXML
    public void initialize() {
        drinksList.setCellFactory(param -> new DrinkCell());
    }

    @FXML
    public void handleAddDrink() {
        String name = drinkNameField.getText();
        String country = countryField.getText();
        String description = descriptionField.getText();
        String abvText = abvField.getText();
        String imageUrl = imageUrlField.getText();

        double abv;
        try {
            abv = Double.parseDouble(abvText);
        } catch (NumberFormatException e) {
            showAlert("Invalid ABV format", "Please enter a valid number for ABV.");
            return;
        }

        Drink drink = new Drink(name, country, description, abv, imageUrl);
        drinksHashTable.put(name, drink);
        drinksList.getItems().add(drink);

        clearFields();
    }

    @FXML
    public void handleAddIngredient() {
        String ingredientName = ingredientNameField.getText();
        String ingredientDescription = ingredientDescriptionField.getText();
        String ingredientAbvText = ingredientAbvField.getText();

        double ingredientAbv;
        try {
            ingredientAbv = Double.parseDouble(ingredientAbvText);
        } catch (NumberFormatException e) {
            showAlert("Invalid ABV format", "Please enter a valid number for ABV.");
            return;
        }

        Ingredient ingredient = new Ingredient(ingredientName, ingredientDescription, ingredientAbv);
        String drinkName = drinkNameField.getText();
        addIngredientToDrink(drinkName, ingredient);
    }

    @FXML
    public void handleAddRecipe() {
        String drinkName = recipeDrinkNameField.getText();
        String ingredientName = recipeIngredientNameField.getText();
        String recipeQuantityText = recipeQuantityField.getText();

        int quantity;
        try {
            quantity = Integer.parseInt(recipeQuantityText);
        } catch (NumberFormatException e) {
            showAlert("Invalid quantity format", "Please enter a valid number for quantity.");
            return;
        }

        Ingredient ingredient = null;
        for (Drink drink : drinksHashTable.values()) {
            for (Ingredient ing : drink.getIngredients()) {
                if (ing.getName().equals(ingredientName)) {
                    ingredient = ing;
                    break;
                }
            }
            if (ingredient != null) break;
        }

        if (ingredient == null) {
            showAlert("Error", "Ingredient not found.");
            return;
        }

        Recipe recipe = new Recipe();
        recipe.addIngredient(ingredient, quantity);
        addRecipeToDrink(drinkName, recipe);
    }

    public void addIngredientToDrink(String drinkName, Ingredient ingredient) {
        Drink drink = drinksHashTable.get(drinkName);
        if (drink != null) {
            drink.addIngredient(ingredient);
        } else {
            showAlert("Error", "Drink not found.");
        }
    }

    public void addRecipeToDrink(String drinkName, Recipe recipe) {
        Drink drink = drinksHashTable.get(drinkName);
        if (drink != null) {
            drink.addRecipe(recipe);
        } else {
            showAlert("Error", "Drink not found.");
        }
    }

    public List<Drink> searchDrinks(String name, double maxAbv) {
        List<Drink> results = new ArrayList<>();
        for (Drink drink : drinksHashTable.values()) {
            if ((name == null || drink.getName().contains(name)) && drink.getAbv() <= maxAbv) {
                results.add(drink);
            }
        }
        results.sort(Comparator.comparing(Drink::getName));
        return results;
    }

    public void deleteDrink(String name) {
        Drink drink = drinksHashTable.get(name);
        if (drink != null) {
            drinksHashTable.put(name, null);
            drinksList.getItems().remove(drink);
        } else {
            showAlert("Error", "Drink not found.");
        }
    }

    public void updateDrink(String name, Drink updatedDrink) {
        Drink drink = drinksHashTable.get(name);
        if (drink != null) {
            drinksHashTable.put(name, updatedDrink);
            int index = drinksList.getItems().indexOf(drink);
            drinksList.getItems().set(index, updatedDrink);
        } else {
            showAlert("Error", "Drink not found.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearFields() {
        drinkNameField.clear();
        countryField.clear();
        descriptionField.clear();
        abvField.clear();
        imageUrlField.clear();
    }
}
