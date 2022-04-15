package com.barosanu.controller;


import com.barosanu.EmailMenager;
import com.barosanu.view.ColorTheme;
import com.barosanu.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    public OptionsWindowController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }
    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;

    @FXML
    void applyBtnAction() {

    }

    @FXML
    void cancelButtonAction() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpPicker();
        setUpSizePicker();
        

    }

    private void setUpSizePicker() {
    }

    private void setUpPicker() {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(viewFactory.getColorTheme());
    }
}
