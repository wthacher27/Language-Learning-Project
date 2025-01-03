package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Locale.LanguageRange;
import java.util.ResourceBundle;

import com.language.App;
import com.model.LanguageAppFacade;
import com.model.User;
import com.narration.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class StruggleLessonPreviewController implements Initializable {
    private LanguageAppFacade facade;
    
    @FXML private Label lbl_title;
    @FXML private Label lbl_error;
    @FXML private TextArea txt_difficultPhrases;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = LanguageAppFacade.getInstance();
        User user = facade.getUser();
        
        if (user != null) {
            txt_difficultPhrases.setText(user.showStruggleList());
        } else {
            lbl_error.setText("User data is not available.");
        }
    }
     
    @FXML
    void advanceToLesson(ActionEvent event) throws IOException {
        LanguageAppFacade facade = LanguageAppFacade.getInstance();
        facade.getUser().makeStudySheet();
        System.out.println(facade.startStruggleLesson());
        facade.resetLesson();
        if(facade.isLessonFinished()){
            lbl_error.setText("You don't have any words you are struggling with :)");
            App.setRoot("learn");
        }
        else
            App.setRoot(facade.getCurrentQuestionType());
    }



    
}