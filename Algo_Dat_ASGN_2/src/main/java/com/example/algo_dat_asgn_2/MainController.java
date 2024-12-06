package com.example.algo_dat_asgn_2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class MainController {

    @FXML
    private TextField drinkNameField, countryField, descriptionField, abvField, imageUrlField;
    @FXML
    private TextField ingredientDrinkNameField, ingredientNameField, ingredientDescriptionField, ingredientAbvField;
    @FXML
    private TextField recipeDrinkNameField, recipeIngredientNameField, recipeQuantityField;
    @FXML
    private ListView<Drinks> drinksList;

    private DoublyLinkedList<Drinks> drinkList = new DoublyLinkedList<>();



    @FXML
    private void initialize() {
        // Set custom cell factory to display detailed drink information
        drinksList.setCellFactory(new Callback<ListView<Drinks>, javafx.scene.control.ListCell<Drinks>>() {
            @Override
            public javafx.scene.control.ListCell<Drinks> call(ListView<Drinks> listView) {
                return new DrinkCell();

            }
        });
    }

    @FXML
    private void handleAddDrink() {
        try {
            String name = drinkNameField.getText();
            String country = countryField.getText();
            String description = descriptionField.getText();
            double abv = Double.parseDouble(abvField.getText());

            Drinks newDrink = new Drinks(name, description, name, country, description, abv);
            drinkList.insertAtEnd(newDrink);
            drinksList.getItems().add(newDrink);

            clearDrinkFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Drink added successfully!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input! Please check your fields.");
        }
    }

    @FXML
    private void handleRemoveDrink() {
        try {
            String drinkName = drinkNameField.getText();

            Drinks drink = findDrinkByName(drinkName);
            if (drink != null) {
                drinkList.remove(drink);
                drinksList.getItems().remove(drink);
                clearDrinkFields();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Drink removed successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Drink not found!");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input! Please check your fields.");
        }
    }

    @FXML
    private void handleAddIngredient() {
        try {
            String drinkName = ingredientDrinkNameField.getText();
            String ingredientName = ingredientNameField.getText();
            String description = ingredientDescriptionField.getText();
            double abv = Double.parseDouble(ingredientAbvField.getText());

            Drinks drink = findDrinkByName(drinkName);
            if (drink != null) {
                Ingredients ingredient = new Ingredients(ingredientName, description, abv);
                drink.addIngredient(ingredient);
                refreshDrinkList();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Ingredient added successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Drink not found!");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input! Please check your fields.");
        }
    }

    @FXML
    private void handleRemoveIngredient() {
        try {
            String drinkName = ingredientDrinkNameField.getText();
            String ingredientName = ingredientNameField.getText();

            Drinks drink = findDrinkByName(drinkName);
            if (drink != null) {
                Ingredients ingredient = findIngredientByName(drink, ingredientName);
                if (ingredient != null) {
                    drink.getIngredients().remove(ingredient);
                    refreshDrinkList();
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Ingredient removed successfully!");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Ingredient not found!");
                }
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Drink not found!");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input! Please check your fields.");
        }
    }



    private void refreshDrinkList() {
        drinksList.getItems().clear();
        DoublyLinkedList.Node<Drinks> current = drinkList.head;
        while (current != null) {
            drinksList.getItems().add(current.data);
            current = current.next;
        }
    }

    private Drinks findDrinkByName(String name) {
        DoublyLinkedList.Node<Drinks> current = drinkList.head;
        while (current != null) {
            if (current.data.getName().equals(name)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    private Ingredients findIngredientByName(Drinks drink, String ingredientName) {
        for (Ingredients ingredient : drinksList.getItems()) {
            if (ingredient.getName().equals(ingredientName)) {
                return ingredient;
            }
        }
        return null;
    }

    private void clearDrinkFields() {
        drinkNameField.clear();
        countryField.clear();
        descriptionField.clear();
        abvField.clear();
        imageUrlField.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
