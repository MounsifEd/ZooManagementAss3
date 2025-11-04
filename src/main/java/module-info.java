module com.example.zoomanagementass3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zoomanagementass3 to javafx.fxml;
    exports com.example.zoomanagementass3;
}