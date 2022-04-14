package com.barosanu.view;

import com.barosanu.EmailMenager;

public class ViewFactory {
    private EmailMenager emailMenager;

    public ViewFactory(EmailMenager emailMenager) {
        this.emailMenager = emailMenager;
    }

    public void showLoginWindow(){
        System.out.println("show colled");
    }
}
