package com.example.quizapp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class QuizController extends LoginController {
    @FXML
    private TextField txtQuestion1;

    @FXML
    private TextField txtQuestion2;

    @FXML
    private TextField txtQuestion3;

    @FXML
    private TextField txtQuestion4;

    @FXML
    private TextField txtQuestion5;

    private String resultMessage(int score) {
        String message;

        if (score < 2) {
            message = "Score: " + score + "/5 \n" + "That's rough! Better luck next time..";
        } else if (score < 4) {
            message = "Score: " + score + "/5 \n" + "Not bad! You're getting there..";
        } else if (score == 4) {
            message = "Score: " + score + "/5 \n" + "An almost perfect score!";
        } else {
            message = "Score: " + score + "/5 \n" + "Great work!";
        }

        return message;
    }

    @FXML
    protected void onSubmitButtonClick() {
        int quizScore = 0;

        TextField[] questionsArray = {txtQuestion1, txtQuestion2, txtQuestion3, txtQuestion4, txtQuestion5};
        String[] answersArray = {"violet", "orange", "blue", "red", "indigo"};

        for (int i = 0; i < questionsArray.length; i++) {
            if (questionsArray[i].getText().equalsIgnoreCase(answersArray[i])) {
                quizScore++;
            }
        }

        Alert results = new Alert(Alert.AlertType.INFORMATION, resultMessage(quizScore), ButtonType.FINISH);

        results.showAndWait();
        Platform.exit();
    }

    @FXML
    protected void onResetButtonClick() {
        TextField[] questionsArray = {txtQuestion1, txtQuestion2, txtQuestion3, txtQuestion4, txtQuestion5};

        for (TextField question : questionsArray) {
            question.setText("");
        }
    }
}