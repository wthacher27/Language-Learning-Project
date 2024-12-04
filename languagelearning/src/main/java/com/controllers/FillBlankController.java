
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

public class FillBlankController implements Initializable {

    @FXML private Label lbl_title;
    @FXML private Label lbl_type;
    @FXML private Label lbl_question;

    private LanguageAppFacade facade;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        facade = LanguageAppFacade.getInstance();
        
        
        lbl_title.setText("Welcome " + facade.getUser().getFirstName() + " " + facade.getUser().getLastName());
        lbl_question.setText(facade.getCurrentQuestionString());
    }   
    @FXML
    void switchToUserHomePage(ActionEvent event) throws IOException {
        

        App.setRoot("primary");
    }

    @FXML
    void submitAnswers(ActionEvent event) throws IOException {
        
        facade.answerCurrentQuestion("");
        App.setRoot("correct_answer");
    }
    
    
}
