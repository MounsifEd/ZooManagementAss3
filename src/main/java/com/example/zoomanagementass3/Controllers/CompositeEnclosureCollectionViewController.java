package com.example.zoomanagementass3.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import com.example.zoomanagementass3.Model.CompositeEnclosureCollection;

import com.example.zoomanagementass3.Model.Enclosure;

import com.example.zoomanagementass3.Model.EnclosureCollection;

import com.example.zoomanagementass3.Helpers.ImportHelper;

import com.example.zoomanagementass3.ZooApplication;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;

import javafx.scene.Scene;

import javafx.scene.Node;

import javafx.scene.control.Button;

import javafx.scene.control.ListView;

import javafx.stage.Modality;

import javafx.stage.Stage;


// public class CompositeEnclosureCollectionViewController {
   // public Button backButton;
   // public ListView bigCatsListView;

    //public void onBackButtonClick(ActionEvent actionEvent) {
       // Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        // stage.close();

    //package com.example.zoomanagementass3.Controllers;

    /**

     * Controller for the Composite Enclosure View.

     * Displays the Big Cats sections (Lions, Tigers, Cougars).

     */

    public class CompositeEnclosureCollectionViewController {

        @FXML

        @FXML
        private ListView<EnclosureCollection> bigCatsListView;

        private  CompositeEnclosureCollection originalCollection;
        private ObservableList<EnclosureCollection> bigCatsList;

        @FXML
        private void initialize() {

            originalCollection = ImportHelper.createAnimals();

            aCollection = FXCollections.observableArrayList(originalCollection.getClass());
            bigCatsListView.setItems(aCollection);
        }


        @FXML

        private Button backButton;

        private CompositeEnclosureCollection rootArea;

        /**

         * Called when the window is opened.

         * Sets the root (Big Cats) structure.

         */

        public void setRootArea(CompositeEnclosureCollection root) {

            this.rootArea = root;

            loadStructure();

        }

        /**

         * Loads Lions, Tigers, Cougars into the ListView.

         */

        private void loadStructure() {

            if (rootArea == null) return;

            // Fill ListView

            bigCatsListView.setItems(rootArea.getaComponent());

            // Double-click to open an enclosure

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

         * Opens enclosure-view.fxml for a specific enclosure.

         */

        private void openEnclosureView(Enclosure enclosure, javafx.scene.input.MouseEvent event) {

            try {

                FXMLLoader fxmlLoader = new FXMLLoader(

                        ZooApplication.class.getResource("enclosure-view.fxml")

                );

                Parent view = fxmlLoader.load();

                EnclosureViewController controller = fxmlLoader.getController();

                controller.setEnclosure(enclosure);

                Scene scene = new Scene(view, 500, 500);

                Stage stage = new Stage();

                stage.setScene(scene);

                stage.setTitle(enclosure.getName());

                stage.initModality(Modality.WINDOW_MODAL);

                stage.initOwner(((Node) event.getSource()).getScene().getWindow());

                stage.showAndWait();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        /**

         * Back button closes the window.

         */

        @FXML

        protected void onBackButtonClick(ActionEvent event) {

            Stage stage = (Stage) backButton.getScene().getWindow();

            stage.close();

        }

    }







