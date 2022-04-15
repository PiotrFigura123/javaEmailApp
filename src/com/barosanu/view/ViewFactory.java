package com.barosanu.view;

import com.barosanu.EmailMenager;
import com.barosanu.controller.BaseController;
import com.barosanu.controller.LoginWindowController;
import com.barosanu.controller.MainWindowController;
import com.barosanu.controller.OptionsWindowController;
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

    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize=FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow(){
        System.out.println("show colled");

        BaseController controller = new LoginWindowController(emailMenager,this, "LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("main window");
        BaseController controller = new MainWindowController(emailMenager,this, "MainWindow.fxml");
        initializeStage(controller);
    }
    public void showOptionsWindow(){
        System.out.println("Options window");
        BaseController controller = new OptionsWindowController(emailMenager,this, "OptionsWindow.fxml");
        initializeStage(controller);

    }

    private void initializeStage(BaseController baseController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
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
    public void closeStage(Stage stageToClose){
        stageToClose.close();
    }
}
