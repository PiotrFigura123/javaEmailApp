package com.barosanu;

import com.barosanu.controller.services.FetchFolderService;
import com.barosanu.controller.services.FolderUpdaterService;
import com.barosanu.model.EmailAccount;
import com.barosanu.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

import javax.mail.Folder;
import java.util.ArrayList;
import java.util.List;

public class EmailMenager {

    private FolderUpdaterService folderUpdaterService;
    //Folder handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");
    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    private List<Folder> folderList = new ArrayList<Folder>();
    public List<Folder> getFolderList(){
        return this.folderList;
    }
    public EmailMenager(){
        folderUpdaterService = new FolderUpdaterService(folderList);
        folderUpdaterService.start();
    }
    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(),treeItem, folderList);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);

    }

}
