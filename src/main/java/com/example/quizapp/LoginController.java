package com.example.quizapp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtInputUsername;

    @FXML
    private PasswordField txtInputPassword;

    public void activateLoginButton() {
        if (!txtInputUsername.getText().isEmpty() && !txtInputUsername.getText().isEmpty()) {
            btnLogin.setDisable(false);
        }
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        String username = "admin";
        String password = "pa55word";

        String inputUsername = txtInputUsername.getText().toLowerCase();
        String inputPassword = txtInputPassword.getText();

        Alert loginSuccessAlert = new Alert(Alert.AlertType.CONFIRMATION, "Welcome! You have successfully logged in.", ButtonType.OK);

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            loginSuccessAlert.showAndWait();
            clearLoginFields();
            switchToQuizScene();

        } else {
            Alert loginFailAlert = new Alert(Alert.AlertType.ERROR, "Username or password is incorrect. Please try again.", ButtonType.OK);
            loginFailAlert.showAndWait();
            clearLoginFields();
        }
    }

    @FXML
    private void clearLoginFields() {
        txtInputUsername.setText("");
        txtInputPassword.setText("");
    }

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }

    @FXML
    private Button btnLogin;

    public void switchToQuizScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXQuizApplication.class.getResource("quiz-view.fxml"));
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setTitle("Rainbow Quiz");
        stage.setScene(scene);
        stage.show();
    }
}