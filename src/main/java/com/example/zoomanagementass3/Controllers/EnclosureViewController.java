package com.example.zoomanagementass3.Controllers;

import com.example.zoomanagementass3.ZooApplication;
import com.example.zoomanagementass3.Model.Animal;
import com.example.zoomanagementass3.Model.Enclosure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the enclosure view handling display and user actions
 * related to animals within a single enclosure.
 *
 * @author Ian
 */
public class EnclosureViewController {

    @FXML
    private Label enclosureLabel;

    @FXML
    private ListView<Animal> animalListView;

    @FXML
    private Button enclosureAddButton;

    @FXML
    private Button enclosureDeleteButton;

    @FXML
    private Button enclosureBackButton;

    private Enclosure enclosure;

    /**
     * Inject the selected enclosure into this controller
     */
    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;

        if (enclosureLabel != null) {
            enclosureLabel.setText(enclosure.getName() + " Enclosure");
        }

        if (animalListView != null) {
            // SHOW the animals inside this enclosure
            animalListView.setItems(enclosure.getAnimals());
        }
    }
    /**
     * Opens Animal Add Window AND gives it this enclosure
     */
    @FXML
    protected void onEnclosureAddButtonClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(ZooApplication.class.getResource("animal-view.fxml"));
        Parent view = loader.load();


        Stage stage = new Stage();
        stage.setScene(new Scene(view));
        stage.setTitle("Add Animal");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.showAndWait(); // wait until window closes

        // After the dialog closes, retrieve the created animal
        AnimalViewController animalCtrl = loader.getController();
        Animal created = animalCtrl.getCreatedAnimal();
        if (created != null) {
            enclosure.addAnimal(created); // ListView updates automatically
        }
    }

    @FXML
    protected void onEnclosureDeleteButtonClick(ActionEvent event) {
        Animal selected = animalListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            enclosure.removeAnimal(selected);
        }
    }

    @FXML
    protected void onEnclosureBackButtonClick(ActionEvent event) {
        Stage stage = (Stage) enclosureBackButton.getScene().getWindow();
        stage.close();
    }
}
