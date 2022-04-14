module EmailApp {
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.controls;

    opens com.barosanu;
    opens com.barosanu.view;
    opens com.barosanu.controller;
}