module com.example.student_project_repository {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.student_project_repository to javafx.fxml;
    exports com.example.student_project_repository;
}