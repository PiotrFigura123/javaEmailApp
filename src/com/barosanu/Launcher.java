package com.barosanu;

import com.barosanu.controller.persistance.Persistance;
import com.barosanu.controller.persistance.ValidAccount;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Persistance persistance = new Persistance();
    private EmailMenager emailMenager = new EmailMenager();

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(emailMenager);
        viewFactory.showLoginWindow();
    }

    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccountList = new ArrayList<ValidAccount>();
        for (EmailAccount emailAccount:emailMenager.getEmailAccounts()){
            validAccountList.add(new ValidAccount(emailAccount.getAddress(), emailAccount.getPassword()));
        }
        persistance.saveToPersistance(validAccountList);
    }
}
