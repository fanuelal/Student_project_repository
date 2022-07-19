package com.example.student_project_repository;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {
@FXML
private AnchorPane splashContainer;
@FXML
private Circle  motionCircle;
@FXML
private Rectangle innerProgress;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anchFader(splashContainer);
        RotateTransition rtCircle = new RotateTransition(Duration.seconds(5),motionCircle);
        rtCircle.setAutoReverse(true);
        rtCircle.setByAngle(180);
        rtCircle.setRate(3);
        rtCircle.setCycleCount(5);
        rtCircle.setOnFinished(event -> {
            Stage stage = (Stage) innerProgress.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        });
        rtCircle.play();
        ScaleTransition st = new ScaleTransition(Duration.seconds(8), innerProgress);
        st.setByX(29);
        st.setCycleCount(1);
        st.setAutoReverse(true);

        st.play();
    }
    public void anchFader(AnchorPane obj){
        FadeTransition ft = new FadeTransition(Duration.millis(2000), obj);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
}
