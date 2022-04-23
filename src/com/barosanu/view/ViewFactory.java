package com.barosanu.view;

import com.barosanu.EmailMenager;
import com.barosanu.controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {
    private EmailMenager emailMenager;
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialized = false;
    public ViewFactory(EmailMenager emailMenager) {

        this.emailMenager = emailMenager;
        activeStages = new ArrayList<Stage>();
    }
    public boolean isMainViewInitialized(){
        return mainViewInitialized;
    }

    private ColorTheme colorTheme = ColorTheme.DARK;
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
        mainViewInitialized = true;
    }
    public void showOptionsWindow(){
        System.out.println("Options window");
        BaseController controller = new OptionsWindowController(emailMenager,this, "OptionsWindow.fxml");
        initializeStage(controller);

    }
    public void showComposeMessageWindow(){
        System.out.println("Compose Message window");
        BaseController controller = new ComposeMessageController(emailMenager,this, "ComposeMessageWindow.fxml");
        initializeStage(controller);

    }
    public void showEmailsDetailsWindow(){
        BaseController controller = new EmailDetailsController(emailMenager,this, "EmailDetailsWindow.fxml");
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
        activeStages.add(stage);
    }
    public void closeStage(Stage stageToClose){

        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    public void updateStyles() {
        for (Stage stage: activeStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }
}
