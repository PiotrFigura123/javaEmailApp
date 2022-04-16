package com.barosanu.controller;

import com.barosanu.EmailMenager;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    @FXML
    private TableView<?> emailTableView;

    @FXML
    private WebView emailWebView;

    @FXML
    private TreeView<String> emailsTreeView;

    public MainWindowController(EmailMenager emailMenager, ViewFactory viewFactory, String fxmlName) {
        super(emailMenager, viewFactory, fxmlName);
    }

    @FXML
    void optionsAction() {
        viewFactory.showOptionsWindow();
    }
    @FXML
    void addAccountAction() {
        viewFactory.showLoginWindow();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpEmailsTreeView();
    }

    private void setUpEmailsTreeView() {
        emailsTreeView.setRoot(emailMenager.getFoldersRoot());
        emailsTreeView.setShowRoot(false);
    }
}
