package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTest {
    @FindBy(id = "btnLogout")
    private WebElement logoutButton;

    @FindBy(id = "fileUpload")
    private WebElement fileUpload;

    @FindBy(id = "btnAddNewNote")
    private WebElement btnAddNewNote;

    @FindBy(id = "btnAddNewCredential")
    private WebElement btnAddNewCredential;

    @FindBy(id = "note-title")
    private WebElement txtNoteTitle;

    @FindBy(id = "nav-notes-tab")
    private WebElement navNotesTab;

    @FindBy(id = "nav-credentials-tab")
    private WebElement navCredentialsTab;

    @FindBy(id = "note-description")
    private WebElement txtNoteDescription;

    @FindBy(id = "btnSaveChanges")
    private WebElement btnSaveChanges;

    @FindBy(id = "tableNoteTitle")
    private WebElement tableNoteTitle;

    @FindBy(id = "tableNoteDescription")
    private WebElement tableNoteDescription;

    @FindBy(id = "btnEditNote")
    private WebElement btnEditNote;

    @FindBy(id = "btnEditCredential")
    private WebElement btnEditCredential;

    @FindBy(id = "note-description")
    private WebElement txtModifyNoteDescription;

    @FindBy(id = "btnDeleteNote")
    private WebElement btnDeleteNote;

    @FindBy(id = "btnDeleteCredential")
    private WebElement btnDeleteCredential;

    @FindBy(id = "credential-url")
    private WebElement txtCredentialUrl;

    @FindBy(id = "credential-username")
    private WebElement txtCredentialUsername;

    @FindBy(id = "credential-password")
    private WebElement txtCredentialPassword;

    @FindBy(id = "btnCredentialSaveChanges")
    private WebElement btnCredentialSaveChanges;

    @FindBy(id = "credentialSubmit")
    private WebElement btnCredentialSubmit;

    @FindBy(id="aResultSuccess")
    private WebElement btnContinue;

    public HomePageTest(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void logout(){
        this.logoutButton.click();
    }

    public void navToNotesTab(){
        this.navNotesTab.click();
    }

    public void navToCredentialsTab(){
        this.navCredentialsTab.click();
    }

    public void addNewNote(String title, String description){
        this.btnAddNewNote.click();
        this.txtNoteTitle.sendKeys(title);
        this.txtNoteDescription.sendKeys(description);
        this.btnSaveChanges.click();
        this.btnContinue.click();
    }

    public void editNote(String title, String description){
        this.navNotesTab.click();
        this.btnEditNote.click();
        this.txtNoteTitle.sendKeys(title);
        this.txtNoteDescription.sendKeys(description);
        this.btnSaveChanges.click();
        this.btnContinue.click();
    }

    public void deleteNote(){
        this.btnDeleteNote.click();
        this.btnContinue.click();
    }

    public void addCredential(String url, String username, String password){
        this.btnAddNewCredential.click();
        this.txtCredentialUrl.sendKeys(url);
        this.txtCredentialUsername.sendKeys(username);
        this.txtCredentialPassword.sendKeys(password);
        this.btnCredentialSaveChanges.click();
        this.btnContinue.click();
    }

    public void editCredential(String url, String username, String password){
        this.btnEditCredential.click();
        this.txtCredentialUrl.sendKeys(url);
        this.txtCredentialUsername.sendKeys(username);
        this.txtCredentialPassword.sendKeys(password);
        this.btnCredentialSaveChanges.click();
        this.btnContinue.click();
    }

    public void deleteCredential(){
        this.btnDeleteCredential.click();
        this.btnContinue.click();
    }
}
