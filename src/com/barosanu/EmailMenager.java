package com.barosanu;

import com.barosanu.model.EmailAccount;
import javafx.scene.control.TreeItem;

public class EmailMenager {


    //Folder handling:
    private TreeItem<String> foldersRoot = new TreeItem<String>("");
    public TreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }
    public void addEmailAccount(EmailAccount emailAccount){
        TreeItem<String> treeItem = new TreeItem<String>(emailAccount.getAddress());
        treeItem.setExpanded(true);
        foldersRoot.getChildren().add(treeItem);

    }

}
