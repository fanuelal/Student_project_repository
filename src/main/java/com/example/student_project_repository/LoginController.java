package com.example.student_project_repository;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
    db_connecter connect = new db_connecter();
    HomeApplication home = new HomeApplication();
    @FXML
    private Hyperlink frgtLink;

    @FXML
    private Button guestBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField psswrd;

    @FXML
    private CheckBox rememberBtn;

    @FXML
    private TextField usrName;
    @FXML
    private Button closeBtn;
    @FXML
    private Label alertText;

    String ErrorMessage = "Correct Input";
    boolean validInput = true;
    public void validInputChecker(){
        if(usrName.getText().isEmpty()){
            ErrorMessage = "Empty UserName!";
            validInput = false;
        }
        if(psswrd.getText().isEmpty()){
            ErrorMessage = "Empty Password!";
            validInput = false;
        }
        if(usrName.getText().isEmpty() & psswrd.getText().isEmpty()){
            ErrorMessage = "Both field are Empty!";
            validInput = false;
        }
        alertText.setText(ErrorMessage);
    }
    public boolean Authentication(){
        String authPassword = connect.getFetchedpassword();
        if(psswrd.getText().equals(authPassword)){
            return true;
        }
        return false;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                validInputChecker();
                if(validInput == true){
                    try {
                        connect.getconnection(Integer.parseInt(usrName.getText()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if(Authentication()) {
                        System.out.println("Successfully login");
                        ErrorMessage = "Successfully login!";
                        alertText.setText(ErrorMessage);
                        Stage stage = (Stage) loginBtn.getScene().getWindow();
                        stage.close();
                        Stage primaryStage = new Stage();
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Home-View.fxml"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        primaryStage.setTitle("Home");
                        primaryStage.setScene(new Scene(root));
                        primaryStage.show();
                    }
                    else{
                        ErrorMessage = "Invalid password / ID!";
                        alertText.setText(ErrorMessage);
                    }
                }
            }
        });
    }
}
