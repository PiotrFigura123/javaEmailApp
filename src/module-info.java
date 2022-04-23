module EmailApp {
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.controls;
    requires activation;
    requires java.mail;
    requires java.desktop;

    opens com.barosanu;
    opens com.barosanu.view;
    opens com.barosanu.controller;
    opens com.barosanu.model;
}