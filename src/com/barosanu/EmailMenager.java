package com.barosanu;

import com.barosanu.controller.services.FetchFolderService;
import com.barosanu.controller.services.FolderUpdaterService;
import com.barosanu.model.EmailAccount;
import com.barosanu.model.EmailMessage;
import com.barosanu.model.EmailTreeItem;
import com.barosanu.view.IconResolver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TreeItem;

import javax.mail.Flags;
import javax.mail.Folder;
import java.util.ArrayList;
import java.util.List;

public class EmailMenager {

    private EmailMessage selectedMessage;
    private EmailTreeItem<String> selectedFolder;
    private ObservableList<EmailAccount> emailAccounts = FXCollections.observableArrayList();
    public ObservableList<EmailAccount> getEmailAccounts(){
        return emailAccounts;
    }
    private IconResolver iconResolver= new IconResolver();

    public EmailTreeItem<String> getSelectedFolder() {
        return selectedFolder;
    }

    public void setSelectedFolder(EmailTreeItem<String> selectedFolder) {
        this.selectedFolder = selectedFolder;
    }

    public EmailMessage getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(EmailMessage selectedMessage) {
        this.selectedMessage = selectedMessage;
    }

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
        emailAccounts.add(emailAccount);
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        treeItem.setGraphic(iconResolver.getIconForFolder(emailAccount.getAddress()));
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(),treeItem, folderList);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);

    }


    public void setRead() {
        try{
        selectedMessage.setRead(true);
        selectedMessage.getMessage().setFlag(Flags.Flag.SEEN, true);
        selectedFolder.decrementMessageCount();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setUnRead() {
        try{
            selectedMessage.setRead(false);
            selectedMessage.getMessage().setFlag(Flags.Flag.SEEN, false);
            selectedFolder.incrementMessageCount();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteSelectedMessage() {
        try{
            selectedMessage.getMessage().setFlag(Flags.Flag.DELETED, true);
            selectedFolder.getEmailMessages().remove(selectedMessage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
