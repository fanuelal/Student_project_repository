package com.example.student_project_repository;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button add;

    @FXML
    private Button edit;

    @FXML
    private Button home;

    @FXML
    private Button notification;

    @FXML
    private Button others;

    @FXML
    private AnchorPane sideBar;
    @FXML
    private ImageView navbtn;
    @FXML
    private AnchorPane sideBarSmaller;
    @FXML
    void addAction(ActionEvent event) {

    }

    @FXML
    void editAction(ActionEvent event) {

    }

    @FXML
    void homeAction(ActionEvent event) {

    }

    @FXML
    void notificationAction(ActionEvent event) {

    }

    @FXML
    void othersAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    navbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(sideBar.isVisible()){
            sideBar.setVisible(false);
            sideBarSmaller.setVisible(true);
            }
            else{
                sideBar.setVisible(true);
                sideBarSmaller.setVisible(false);
            }
        }
    });
}
}