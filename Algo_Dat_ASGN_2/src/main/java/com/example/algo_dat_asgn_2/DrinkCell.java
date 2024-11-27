package com.example.algo_dat_asgn_2;

import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DrinkCell extends ListCell<Drinks> {
    private VBox content;
    private Text name;
    private Text country;
    private Text description;
    private Text abv;
    private Text ingredients;

    public DrinkCell() {
        super();
        name = new Text();
        country = new Text();
        description = new Text();
        abv = new Text();
        ingredients = new Text();
        content = new VBox(name, country, description, abv, ingredients);
        content.setSpacing(5);
    }

    @Override
    protected void updateItem(Drinks item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            name.setText("Name: " + item.getName());
            country.setText("Origin: " + item.getCountryOfOrigin());
            description.setText("Description: " + item.getdDescription());
            abv.setText("ABV: " + item.getAbv());

            StringBuilder ingredientsText = new StringBuilder("Recipe:");
            DoublyLinkedList.Node<Ingredients> current = item.getIngredients().getHead();
            while (current != null) {
                Ingredients ing = current.data;
                ingredientsText.append("\n  - ")
                        .append(ing.getName())
                        .append(": ")
                        .append(ing.getDescription())
                        .append(" (ABV: ")
                        .append(ing.getAbv())
                        .append("%)");
                current = current.next;
            }

            ingredients.setText(ingredientsText.toString());
            setGraphic(content);
        } else {
            setGraphic(null);
        }
    }
}
