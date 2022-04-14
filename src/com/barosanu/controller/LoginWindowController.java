package com.barosanu.controller;

import com.barosanu.EmailMenager;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController extends BaseController {


    @FXML
    private TextField emailAdressField;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }

    //@FXML
   // void cancelLoginAction(ActionEvent event) {

    //}

    @FXML
    void loginButtonAction() {
        System.out.println("click");
    }
}
