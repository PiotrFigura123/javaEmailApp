package com.barosanu.controller;

import com.barosanu.EmailMenager;
import com.barosanu.view.ViewFactory;

public abstract class BaseController {
    protected EmailMenager emailMenager;
    protected ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        this.emailMenager = emailMenager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }


}
