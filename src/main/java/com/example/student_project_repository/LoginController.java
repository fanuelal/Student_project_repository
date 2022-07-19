package com.example.student_project_repository;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
    db_connecter connect = new db_connecter();
    HomeApplication home = new HomeApplication();
    RouteProtector route = new RouteProtector();
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
    @FXML
    private AnchorPane loginBox;
    @FXML
    private AnchorPane loginContainer;
    @FXML
    private ImageView loginimg;
    @FXML
    private Text logoTitle;

    String ErrorMessage = "Correct Input";
    boolean validInput = true;

    public void RememberMe(){

    }
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
        if(!usrName.getText().isEmpty() & !psswrd.getText().isEmpty()){
            validInput = true;
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
        loginIntro();
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
                        alertText.setText(ErrorMessage);
                        Stage stage = (Stage) loginBtn.getScene().getWindow();
                        stage.close();
                        route.setProtectedRoute(true);
                        Stage primaryStage = new Stage();
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Home-View.fxml"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        primaryStage.setTitle("Student Repo");
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
        guestBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("logged in with Guest");
                Stage stage = (Stage) guestBtn.getScene().getWindow();
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
        });
    }
    public void loginIntro(){
        TranslateTransition transition1 = new TranslateTransition();
        transition1.setByX(-67);
        transition1.setDuration(Duration.millis(3000));
        transition1.setCycleCount(1);
        transition1.setNode(loginBox);
        transition1.play();
        TranslateTransition transition2 = new TranslateTransition();
        transition2.setByX(123);
        transition2.setDuration(Duration.millis(3000));
        transition2.setCycleCount(1);
        transition2.setNode(loginimg);
        transition2.play();
        //for loginContainer
        FadeTransition ft = new FadeTransition(Duration.millis(2000), loginContainer);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
}
