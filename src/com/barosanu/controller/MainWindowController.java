package com.barosanu.controller;

import com.barosanu.EmailMenager;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends BaseController {

    @FXML
    private TableView<?> emailTableView;

    @FXML
    private WebView emailWebView;

    @FXML
    private TreeView<?> emailsTreeView;

    public MainWindowController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }

    @FXML
    void optionsAction() {
        viewFactory.showOptionsWindow();
    }
}
