package com.barosanu.controller;


import com.barosanu.EmailMenager;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

public class OptionsWindowController extends BaseController {

    public OptionsWindowController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }
    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<?> themePicker;

    @FXML
    void applyBtnAction() {

    }

    @FXML
    void cancelButtonAction() {

    }
}
