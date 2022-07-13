module com.example.ui {
    requires javafx.controls;
    requires javafx.fxml;

    requires controlsfx;
    opens com.example.ui to javafx.fxml;
    exports com.example.ui;
}