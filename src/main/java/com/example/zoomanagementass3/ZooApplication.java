package com.example.zoomanagementass3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("composite-enclosure-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 458);
=======
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
>>>>>>> 1a4dfe717be26d520c9ff7b83c79c21b1fca3b14
        stage.setTitle("Big Cats");
        stage.setScene(scene);
        stage.show();
    }
}
