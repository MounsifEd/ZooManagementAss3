package com.example.zoomanagementass3.Controllers;

import com.example.zoomanagementass3.Model.CompositeEnclosureCollection;
import com.example.zoomanagementass3.Model.Enclosure;
import com.example.zoomanagementass3.Model.EnclosureCollection;
import com.example.zoomanagementass3.ZooApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controller for displaying a composite enclosure collection view.
 * Shows a list of sub-enclosures or animals within a category (e.g., "Big Cats").
 * @author Nelly
 */
public class CompositeEnclosureCollectionViewController {

    @FXML
    private ListView<EnclosureCollection> bigCatsListView;

    @FXML
    private Button backButton;

    private CompositeEnclosureCollection rootArea;

    /**
     * Sets the root composite collection (e.g., "Big Cats") and loads its children.
     *
     * @param root the composite collection to display
     */
    public void setRootArea(CompositeEnclosureCollection root) {
        this.rootArea = root;
        loadStructure();
    }

    /**
     * Loads the list of enclosures inside the composite area.
     */
    private void loadStructure() {
        if (rootArea == null) return;

        bigCatsListView.setItems(FXCollections.observableArrayList(rootArea.getCollections()));

        bigCatsListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                EnclosureCollection selected =
                        bigCatsListView.getSelectionModel().getSelectedItem();

                if (selected instanceof Enclosure enclosure) {
                    openEnclosureView(enclosure, event);
                }
            }
        });
    }

    /**
     * Opens the detailed view for a specific enclosure and its animals.
     */
    private void openEnclosureView(Enclosure enclosure, javafx.scene.input.MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
            Parent view = loader.load();

            EnclosureViewController controller = loader.getController();
            controller.setEnclosure(enclosure);

            Stage stage = new Stage();
            stage.setScene(new Scene(view));
            stage.setTitle(enclosure.getName());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the current window when the Back button is clicked.
     */
    @FXML
    protected void onBackButtonClick(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
