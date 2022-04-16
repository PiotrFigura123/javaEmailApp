package com.barosanu.controller;

import com.barosanu.EmailMenager;
import com.barosanu.controller.services.LoginService;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {


    @FXML
    private TextField emailAdressField;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }


    @FXML
    void loginButtonAction() {
        System.out.println("loginButtonAction!");
        if(fieldsAreVlid()){
            EmailAccount emailAccount = new EmailAccount(emailAdressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailMenager);
            loginService.start();
            loginService.setOnSucceeded(event -> {
                EmailLoginResult emailLoginResult = loginService.getValue();
                switch (emailLoginResult){
                    case SUCCESS:
                        System.out.println("login success!!!" +emailAccount);
                        viewFactory.showMainWindow();
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                        return;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("invalid credentials");
                        return;
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel.setText("unexpecte error!");
                        return;
                    default:
                        return;
                }

            });

        }


    }

    private boolean fieldsAreVlid() {
        if(emailAdressField.getText().isEmpty()){
            errorLabel.setText("please fill email");
            return false;
        }
        if(passwordField.getText().isEmpty()){
            errorLabel.setText("Please fill password");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailAdressField.setText("testpf64@gmail.com");
        passwordField.setText("Maj2021!");
    }
}
