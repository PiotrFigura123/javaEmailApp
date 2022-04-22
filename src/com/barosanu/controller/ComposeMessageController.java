package com.barosanu.controller;

import com.barosanu.EmailMenager;
import com.barosanu.controller.services.EmailSenderService;
import com.barosanu.controller.services.EmailSendingResult;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ComposeMessageController extends BaseController implements Initializable {
    @FXML
    private Label errorLabel;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private TextField recipientTextField;
    @FXML
    private ChoiceBox<EmailAccount> emailAccountChoice;
    @FXML
    private TextField subjectTextField;

    @FXML
    void sendButtonAction() {
        EmailSenderService emailSenderService = new EmailSenderService(
                emailAccountChoice.getValue(),
                subjectTextField.getText(),
                recipientTextField.getText(),
                htmlEditor.getHtmlText()
        );
        emailSenderService.start();
        emailSenderService.setOnSucceeded(e->{
            EmailSendingResult emailSendingResult = emailSenderService.getValue();
            switch (emailSendingResult) {
                case SUCCESS:
                    Stage stage = (Stage) recipientTextField.getScene().getWindow();
                    viewFactory.closeStage(stage);
                    break;
                case FAILED_BY_PRIVIDER:
                    errorLabel.setText("Provider error");
                    break;
                case FAILED_BY_UNEXPEXTED_ERROR:
                    errorLabel.setText("Unepected error");
                    break;
            }
        });
    }

    public ComposeMessageController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailAccountChoice.setItems(emailMenager.getEmailAccounts());
        emailAccountChoice.setValue(emailMenager.getEmailAccounts().get(0));
    }
}
