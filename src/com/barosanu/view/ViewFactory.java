package com.barosanu.view;

import com.barosanu.EmailMenager;
import com.barosanu.controller.BaseController;
import com.barosanu.controller.LoginWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private EmailMenager emailMenager;

    public ViewFactory(EmailMenager emailMenager) {
        this.emailMenager = emailMenager;
    }

    public void showLoginWindow(){
        System.out.println("show colled");

        BaseController controller = new LoginWindowController(emailMenager,this, "LoginWindow.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try{
            parent = fxmlLoader.load();
        }catch(IOException e){
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();



    }
}
