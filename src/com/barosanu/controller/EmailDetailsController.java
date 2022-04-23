package com.barosanu.controller;

import com.barosanu.EmailMenager;
import com.barosanu.controller.services.MessageRendererService;
import com.barosanu.model.EmailMessage;
import com.barosanu.view.ViewFactory;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import java.net.URL;
import java.util.ResourceBundle;

public class EmailDetailsController extends BaseController implements Initializable {

    private String LOCATION_OF_DOWNLOADS = "C:\\Users\\Admin\\Desktop\\Nowy\\";
    @FXML
    private HBox hboxDownloads;//C:\Users\Admin\Desktop\Nowy folder

    @FXML
    private Label senderLabel;

    @FXML
    private Label subjectLabel;

    @FXML
    private WebView webView;
    @FXML
    private Label attachmentLabel;
    public EmailDetailsController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmailMessage emailMessage = emailMenager.getSelectedMessage();
        subjectLabel.setText(emailMessage.getSubject());
        senderLabel.setText(emailMessage.getSender());
        loadAttachment(emailMessage);

        MessageRendererService messageRendererService = new MessageRendererService(webView.getEngine());
        messageRendererService.setEmailMessage(emailMessage);
        messageRendererService.restart();

    }

    private void loadAttachment(EmailMessage emailMessage)  {
        if(emailMessage.hasAttachments()){
            for(MimeBodyPart mimeBodyPart:emailMessage.getAttachmentList()){
                try{
                    AttachmentButton button = new AttachmentButton(mimeBodyPart);
                    hboxDownloads.getChildren().add(button);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

            }
        }else{
            attachmentLabel.setText("");
        }
    }
    private class AttachmentButton extends Button{
        private MimeBodyPart mimeBodyPart;
        private String downloadedFieldPath;
        public AttachmentButton(MimeBodyPart mimeBodyPart) throws MessagingException {
            this.mimeBodyPart=mimeBodyPart;
            this.setText(mimeBodyPart.getFileName());
            this.downloadedFieldPath=LOCATION_OF_DOWNLOADS + mimeBodyPart.getFileName();
            this.setOnAction(event -> downloadAttachment());

        }
        private void downloadAttachment(){
            Service service = new Service(){

                @Override
                protected Task createTask() {
                    return new Task() {
                        @Override
                        protected Object call() throws Exception {

                            mimeBodyPart.saveFile(downloadedFieldPath);
                            return null;
                        }
                    };
                }
            };
            service.restart();

        }
    }
}
