package com.barosanu.controller.services;

import com.barosanu.model.EmailMessage;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.web.WebEngine;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import java.io.IOException;

public class MessageRendererService extends Service {
    private EmailMessage emailMessage;
    private WebEngine webEngine;
    private StringBuffer stringBuffer;

    public MessageRendererService(WebEngine webEngine) {
        this.webEngine = webEngine;
        stringBuffer = new StringBuffer();
    }

    public void setEmailMessage(EmailMessage emailMessage){
        this.emailMessage = emailMessage;
    }

    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                return null;
            }
        };
    }
    private void loadMessage() throws MessagingException, IOException {
        stringBuffer.setLength(0);
        Message message= emailMessage.getMessage();
        String contentType = message.getContentType();
        if(isSimpleType(contentType)){
            stringBuffer.append(message.getContent().toString());
        }else if(isMultipleType(contentType)){
            Multipart multipart = (Multipart) message.getContent();
            for(int i= multipart.getCount()-1;i>=0;i--){
                BodyPart bodyPart = multipart.getBodyPart(i);
                String bodyPartContentType = bodyPart.getContentType();
                if(isSimpleType(bodyPartContentType)){
                    stringBuffer.append(bodyPart.getContent().toString());
                }

            }
        }
    }
    private boolean isSimpleType(String contentType){
        if(contentType.contains("TEXT/HTML") ||
        contentType.contains("mixed") ||
        contentType.contains("text")){
            return true;
        }else
            return false;
    }
    private boolean isMultipleType(String contentType){
        if (contentType.contains("multipart")) {
            return true;
        }else{
            return false;
        }
    }
}
