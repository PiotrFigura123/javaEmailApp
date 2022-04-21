package com.barosanu.controller;

import com.barosanu.EmailMenager;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

public class ComposeMessageController extends BaseController{
    @FXML
    private Label errorLabel;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private TextField recipientTextField;

    @FXML
    private TextField subjectTextField;

    @FXML
    void sendButtonAction() {
        System.out.println(htmlEditor.getHtmlText());
        System.out.println("send button");

    }

    public ComposeMessageController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }
}
