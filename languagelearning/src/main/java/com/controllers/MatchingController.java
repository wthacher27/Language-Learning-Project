
package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.language.App;
import com.model.LanguageAppFacade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MatchingController implements Initializable {

    @FXML private Label lbl_question;

    @FXML private Button btn_base1;
    @FXML private Button btn_base2;
    @FXML private Button btn_base3;
    @FXML private Button btn_learning1;
    @FXML private Button btn_learning2;
    @FXML private Button btn_learning3;
    @FXML private Button btn_base_answer1;
    @FXML private Button btn_base_answer2;
    @FXML private Button btn_base_answer3;
    @FXML private Button btn_learning_answer1;
    @FXML private Button btn_learning_answer2;
    @FXML private Button btn_learning_answer3;

    private String lastClickedBase;
    private String lastClickedLearning;
    private int[] answerOrder;
    private int lastClickedNum;
    
    private LanguageAppFacade facade;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        facade = LanguageAppFacade.getInstance();
       
        lbl_question.setText(facade.getCurrentQuestionString());
        String answers = facade.getAnswerChoices();
        String[] temp = answers.split("!");
        String[] baseSet = temp[0].split("#");
        String[] learningSet = temp[1].split("#");
        // System.out.println("Base set");
        // for(String s : baseSet)
        //     System.out.println(s);
        // System.out.println("Learning set");
        // for(String s : learningSet)
        //     System.out.println(s);
        btn_base1.setText(baseSet[0]);
        btn_base2.setText(baseSet[1]);
        btn_base3.setText(baseSet[2]);
        btn_learning1.setText(learningSet[0]);
        btn_learning2.setText(learningSet[1]);
        btn_learning3.setText(learningSet[2]);
        lastClickedBase = null;
        lastClickedLearning = null;
        answerOrder = new int[6];
        lastClickedNum = -1;
    }   
    

    @FXML
    void clickedBtnBase1(ActionEvent event) throws IOException {
        lastClickedBase = btn_base1.getText();
        lastClickedLearning = null;
        lastClickedNum = 1;
    }

    @FXML
    void clickedBtnBase2(ActionEvent event) throws IOException {
        lastClickedBase = btn_base2.getText();
        lastClickedLearning = null;
        lastClickedNum = 2;
    }

    @FXML
    void clickedBtnBase3(ActionEvent event) throws IOException {
        
        lastClickedBase = btn_base3.getText();
        lastClickedLearning = null;
        lastClickedNum = 3;
    }

    @FXML
    void clickedBtnLearning1(ActionEvent event) throws IOException {
        lastClickedBase = null;
        lastClickedLearning = btn_learning1.getText();
        lastClickedNum = 1;
    }
    @FXML
    void clickedBtnLearning2(ActionEvent event) throws IOException {
        lastClickedBase = null;
        lastClickedLearning = btn_learning2.getText();
        lastClickedNum = 2;
    }
    @FXML
    void clickedBtnLearning3(ActionEvent event) throws IOException {
        lastClickedBase = null;
        lastClickedLearning = btn_learning3.getText();
        lastClickedNum = 3;
    }

    @FXML
    void clickedBtnBaseAnswer1(ActionEvent event) throws IOException {
        if(lastClickedBase != null) {
            btn_base_answer1.setText(lastClickedBase);
            lastClickedBase = null;
            answerOrder[0] = lastClickedNum;
        }
    }

    @FXML
    void clickedBtnBaseAnswer2(ActionEvent event) throws IOException {
        if(lastClickedBase != null) {
            btn_base_answer2.setText(lastClickedBase);
            lastClickedBase = null;
            answerOrder[2] = lastClickedNum;
        }
    }

    @FXML
    void clickedBtnBaseAnswer3(ActionEvent event) throws IOException {
        if(lastClickedBase != null) {
            btn_base_answer3.setText(lastClickedBase);
            lastClickedBase = null;
            answerOrder[4] = lastClickedNum;
        }
    }

    @FXML
    void clickedBtnLearningAnswer1(ActionEvent event) throws IOException {
        if(lastClickedLearning != null) {
            btn_learning_answer1.setText(lastClickedLearning);
            lastClickedLearning = null;
            answerOrder[1] = lastClickedNum;
        }
    }

    @FXML
    void clickedBtnLearningAnswer2(ActionEvent event) throws IOException {
        if(lastClickedLearning != null) {
            btn_learning_answer2.setText(lastClickedLearning);
            lastClickedLearning = null;
            answerOrder[3] = lastClickedNum;
        }
    }

    @FXML
    void clickedBtnLearningAnswer3(ActionEvent event) throws IOException {
        if(lastClickedLearning != null) {
            btn_learning_answer3.setText(lastClickedLearning);
            lastClickedLearning = null;
            answerOrder[5] = lastClickedNum;
        }
    }



    @FXML
    void submitAnswers(ActionEvent event) throws IOException {
        
        String str = "";
        for(int i = 0; i < answerOrder.length; i++){
            if(i > 0 && i%2 == 0)
                str +=",";
            str+=""+answerOrder[i];
        }
        System.out.println(str);
        if(facade.answerCurrentQuestion(str))
            App.setRoot("correct_answer");
        else
            App.setRoot("incorrect_answer"); 
    }

    @FXML
    void switchToUserHomePage(ActionEvent event) throws IOException {
        

        App.setRoot("lesson_summary");
    }


    
    
}
