package com.barosanu.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {


    @FXML
    private TextField emailAdressField;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordField;

    //@FXML
   // void cancelLoginAction(ActionEvent event) {

    //}

    @FXML
    void loginButtonAction() {
        System.out.println("click");
    }
}
