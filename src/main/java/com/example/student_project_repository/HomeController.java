package com.example.student_project_repository;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    FileChooser fileChooser = new FileChooser();
    static LoginController details = new LoginController();
    db_connecter connect = new db_connecter();
    RouteProtector route = new RouteProtector();
    @FXML
    private Button addProject;

    @FXML
    private Button edit;

    @FXML
    private Button home;
    @FXML
    private Button profile;

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
    private Button navbtncls;
    @FXML
    private AnchorPane profileAnc;
    @FXML
    private AnchorPane homeAnc;
    @FXML
    private Button home1;
    @FXML
    private Button balance;
    @FXML
    private AnchorPane BalanceAnc;

    @FXML
    private Pane notifyPane;
    @FXML
    private Rectangle notificationRect;
    @FXML
    private AnchorPane aboutAnc;
    @FXML
    private Button homeSmall1;
    @FXML
    private AnchorPane addProjectAnc;
    @FXML
    private Label userNameLabel;
    @FXML
    public void homeMenuPressed(ActionEvent event){
        homeAnc.setVisible(true);
        profileAnc.setVisible(false);
        BalanceAnc.setVisible(false);
        notifyPane.setVisible(false);
        notificationRect.setVisible(false);
        aboutAnc.setVisible(false);
        addProjectAnc.setVisible(false);
        withdrawFailer.setVisible(false);
        withdrawSuccess.setVisible(false);
    }
    @FXML
    public void balanceBtnPressed(ActionEvent event){
        homeAnc.setVisible(false);
        profileAnc.setVisible(false);
        BalanceAnc.setVisible(true);
        notifyPane.setVisible(false);
        notificationRect.setVisible(false);
        aboutAnc.setVisible(false);
        addProjectAnc.setVisible(false);
        withdrawFailer.setVisible(false);
        withdrawSuccess.setVisible(false);
    }
    @FXML
    public void profileBtnPressed(ActionEvent event){
        profileAnc.setVisible(true);
        BalanceAnc.setVisible(false);
        homeAnc.setVisible(false);
        notifyPane.setVisible(false);
        notificationRect.setVisible(false);
        aboutAnc.setVisible(false);
        addProjectAnc.setVisible(false);
        withdrawFailer.setVisible(false);
        withdrawSuccess.setVisible(false);
    }
    @FXML
    public void addProjectPressed(){
        addProjectAnc.setVisible(true);
        profileAnc.setVisible(false);
        BalanceAnc.setVisible(false);
        homeAnc.setVisible(false);
        notifyPane.setVisible(false);
        notificationRect.setVisible(false);
        aboutAnc.setVisible(false);
        withdrawFailer.setVisible(false);
        withdrawSuccess.setVisible(false);
    }

    @FXML
    public void notificationBtnPressed(ActionEvent event){
        if(notifyPane.isVisible()){
            notifyPane.setVisible(false);
            notificationRect.setVisible(false);
            withdrawFailer.setVisible(false);
            withdrawSuccess.setVisible(false);
        }
        else {
            notifyPane.setVisible(true);
            notificationRect.setVisible(true);
            withdrawFailer.setVisible(false);
            withdrawSuccess.setVisible(false);
        }
    }
    @FXML
    public void aboutBtnPressed(ActionEvent  event){
        profileAnc.setVisible(false);
        BalanceAnc.setVisible(false);
        homeAnc.setVisible(false);
        notifyPane.setVisible(false);
        notificationRect.setVisible(false);
        aboutAnc.setVisible(true);
    }
    String imagePath = "";
    @FXML
    void uploadBtnPressed(ActionEvent event) throws FileNotFoundException {
        File file = fileChooser.showOpenDialog(new Stage());
        try {
            imagePath = file.getAbsolutePath();
        }catch(Exception e){
            e.fillInStackTrace();
        }
        InputStream stream = new FileInputStream(imagePath);
        Image image = new Image(stream);
        trialImage.setImage(image);
    }
    @FXML
    private Label fullNameLable;
    @FXML
    private Label idLabel;
    @FXML
    private Label projectNum;
    @FXML
    private PasswordField confirmPassField;
    @FXML
    private PasswordField oldPassField;
    @FXML
    private PasswordField newPassField;
    @FXML
    private Button updatePassBtn;
    @FXML
    private Pane errorMsg;
    @FXML
    private Label errMsgLabel;
    @FXML
    private Label balanceAmount;
    @FXML
    private TextField withdrawableBalance;
    @FXML
    private Button withdrawBtn;
    @FXML
    private Label withdrawMessageLabel;
    @FXML
    private Pane withdrawSuccess;
    @FXML
    private Pane withdrawFailer;
    @FXML
    private Label failermsgwithdraw;
    @FXML
    private Label projectTitleLabel;
    @FXML
    private Label projeDescLabel;
    @FXML
    private Button addProjectBtn;
    @FXML
    private Label ownerLabel;
    @FXML
    private TextField projTitleField;
    @FXML
    private TextField projCatagoryField;
    @FXML
    private TextField projectPrice;
    @FXML
    private TextArea projectDesc;
    @FXML
    private ImageView trialImage;
    @FXML
    private ImageView projectImageView;
    @FXML
    private Button addBigerNav;
    @FXML
    private Button balanceBigerNav;
    @FXML
    private Button notificationBn;
    @FXML
    private Button EditPBn;
    @FXML
    private Pane projAddSucces;
    @FXML
    private Label projeDescLabel1;
    @FXML
    private Label ownerLabel1;
    @FXML
    private Label projectTitleLabel1;
    @FXML
    private Label projectTitleLabel2;
    @FXML
    private Label projeDescLabel2;
    @FXML
    private Label ownerLabel2;
    @FXML
    private Pane projeDescPane;
    @FXML
    private ImageView projectImageView1;
    @FXML
    private ImageView projectImageView2;
    public void setListProjectOnlabel(){
        projectTitleLabel.setText(connect.projectTitle[0]);
        projeDescLabel.setText(connect.projectDesc[0]);
        ownerLabel.setText(connect.projectOwnerFirstName[0]);
        projectTitleLabel1.setText(connect.projectTitle[1]);
        projeDescLabel1.setText(connect.projectDesc[1]);
        ownerLabel1.setText(connect.projectOwnerFirstName[1]);
        projectTitleLabel2.setText(connect.projectTitle[2]);
        projeDescLabel2.setText(connect.projectDesc[2]);
        ownerLabel2.setText(connect.projectOwnerFirstName[2]);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            connect.getProjectList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        projectTitleLabel.setText(connect.projectTitle[0]);
        projeDescLabel.setText(connect.projectDesc[0]);
        ownerLabel.setText(connect.projectOwnerFirstName[0]);
        projectTitleLabel1.setText(connect.projectTitle[1]);
        projeDescLabel1.setText(connect.projectDesc[1]);
        ownerLabel1.setText(connect.projectOwnerFirstName[1]);
        projectTitleLabel2.setText(connect.projectTitle[2]);
        projeDescLabel2.setText(connect.projectDesc[2]);
        ownerLabel2.setText(connect.projectOwnerFirstName[2]);
        InputStream strm = null, strm1 = null, strm2 = null;
        try {
            strm = new FileInputStream(connect.imagePath[0]);
            strm1 = new FileInputStream(connect.imagePath[1]);
            strm2 = new FileInputStream(connect.imagePath[2]);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Is the Route Secure: " + route.isProtectedRoute());
        if(route.isProtectedRoute() == false){
            addProject.setDisable(true);
            balance.setDisable(true);
            notification.setDisable(true);
            profile.setDisable(true);
            addBigerNav.setDisable(true);
            balanceBigerNav.setDisable(true);
            notificationBn.setDisable(true);
            EditPBn.setDisable(true);
            userNameLabel.setText("Guest");
        }else{
            addProject.setDisable(false);
            balance.setDisable(false);
            notification.setDisable(false);
            profile.setDisable(false);
            addBigerNav.setDisable(false);
            balanceBigerNav.setDisable(false);
            notificationBn.setDisable(false);
            EditPBn.setDisable(false);
            userNameLabel.setText("Guest");
            String firstName = connect.getFetchedfirstName();
            String lastName = connect.getFetchedlastName();
            String oldpassword = connect.getFetchedpassword();
            int StudentID = connect.getFetchedStudentID();
            float Balance = connect.getFetchedBalance();
            int projectNumber = connect.getFetchedprojectNum();
            if(!firstName.equals(null)){userNameLabel.setText(firstName);}
            fullNameLable.setText("Name: "+ firstName + " "+ lastName);
            idLabel.setText("ID No: "+String.valueOf(StudentID));
            projectNum.setText("No. Projects: " + String.valueOf(projectNumber));
            balanceAmount.setText("Total amount: " + String.valueOf(Balance));
            addProjectBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        connect.addProject(projTitleField.getText(), projCatagoryField.getText(), projectDesc.getText(),projectPrice.getText(), String.valueOf(1),imagePath, StudentID);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    projTitleField.setText("");
                    projCatagoryField.setText("");
                    projectPrice.setText("");
                    projectDesc.setText("");
                    projAddSucces.setVisible(true);

                }
            });
            withdrawBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    float withdrawMoneyRequest = 0;
                    withdrawMoneyRequest = Float.parseFloat(withdrawableBalance.getText());
                    try {
                        connect.getconnection(StudentID);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    float updatedbalance = connect.getFetchedBalance();
                    if (updatedbalance >= withdrawMoneyRequest) {
                        updatedbalance -= withdrawMoneyRequest;
                        try {
                            connect.withdrawMoney(updatedbalance, StudentID);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        balanceAmount.setText("Total amount: " + String.valueOf(updatedbalance));
                        withdrawableBalance.setText("");
                        String Success = "withdraw successfully!";
                        withdrawSuccess.setVisible(true);
                        withdrawMessageLabel.setText(Success);
                        withdrawFailer.setVisible(false);
                    }else{
                        String ErrorMessage = "Insufficient Balance";
                        failermsgwithdraw.setText(ErrorMessage);
                        withdrawFailer.setVisible(true);
                        withdrawSuccess.setVisible(false);
                    }
                }
            });
            updatePassBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(oldPassField.getText().equals(oldpassword)){
                        if(newPassField.getText().equals(confirmPassField.getText())){
                            try {
                                connect.getupdatePassword(StudentID, String.valueOf(newPassField.getText()));
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("updated!");
                        }else{
                            String ErrorMessage = "Confirmation password is different!";
                            errorMsg.setVisible(true);
                            errMsgLabel.setText(ErrorMessage);
                        }
                    }else{
                        String ErrorMessage = "Incorrect old password";
                        errorMsg.setVisible(true);
                        errMsgLabel.setText(ErrorMessage);
                    }
                }
            });
        }
        Image image = new Image(strm);
        Image image1 = new Image(strm1);
        Image image2 = new Image(strm2);
        projectImageView.setImage(image);
        projectImageView1.setImage(image1);
        projectImageView2.setImage(image2);
        try {
            connect.getProjectList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    navbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(!sideBar.isVisible()){
            sideBar.setVisible(true);
            anchFader(sideBar);
            sideBarSmaller.setVisible(false);
            }
        }
    });
        navbtncls.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(sideBar.isVisible()){
                    sideBarSmaller.setVisible(true);
                    sideBar.setVisible(false);
                    anchFader(sideBarSmaller);
                }
            }
        });
}
public void anchFader(AnchorPane obj){
        FadeTransition ft = new FadeTransition(Duration.millis(500), obj);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }

}