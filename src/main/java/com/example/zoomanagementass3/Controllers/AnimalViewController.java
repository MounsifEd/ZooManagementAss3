package com.example.zoomanagementass3.Controllers;

import com.example.zoomanagementass3.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller for the Animal View window.
 * creation of a new animal by type, age, name and returns it
 * @Author Mounsif
 */
public class AnimalViewController {

    @FXML
    private ChoiceBox<String> animalTypeChoiceBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private Button saveAnimalButton;

    @FXML
    private Button cancelButton;

    private Animal createdAnimal;

    public Animal getCreatedAnimal() {
        return createdAnimal;
    }

    @FXML
    private void initialize() {
        animalTypeChoiceBox.getItems().addAll("Lion", "Tiger", "Cougar");
    }

    @FXML
    private void onSaveButtonClick(ActionEvent event) {

        String type = animalTypeChoiceBox.getValue();
        String name = nameTextField.getText();
        String ageText = ageTextField.getText();

        if (type == null || name.isBlank() || ageText.isBlank()) {
            showError("Please fill all fields.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            showError("Please enter a valid age number.");
            return;
        }

        if (type.equals("Lion")) {
            createdAnimal = new Lion(name, age);
        } else if (type.equals("Tiger")) {
            createdAnimal = new Tiger(name, age);
        } else if (type.equals("Cougar")) {
            createdAnimal = new Cougar(name, age);
        }


        Stage stage = (Stage) saveAnimalButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onCancelButtonClick(ActionEvent event) {
        createdAnimal = null;

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

