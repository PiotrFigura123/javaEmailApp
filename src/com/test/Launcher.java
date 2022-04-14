package com.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button();
        btn.setText("Hi");
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root,300,300);
        stage.setScene(scene);
        stage.show();
    }

}
