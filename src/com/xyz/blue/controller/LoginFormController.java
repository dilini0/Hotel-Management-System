package com.xyz.blue.controller;

import com.sun.deploy.panel.RuleSetViewerDialog;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginFormController {

    public AnchorPane loginFormContext;
    public TextField textUserName;
    public TextField txtPassword;


    public void loginOnAction(ActionEvent actionEvent) throws IOException {

        String username = textUserName.getText();
        String password = txtPassword.getText();

        // Check if username and password match
        if (username.equals("admin") && password.equals("password")) {
            // Show dashboard and hide login form
            //dashboardContext.setVisible(true);
            setUi("DashboardForm");
            loginFormContext.setVisible(false);

        } else {
            // Incorrect credentials, display an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Username or Password");
            alert.setContentText("Please enter valid credentials.");
            alert.showAndWait();
        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) loginFormContext.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))
        ));
        stage.centerOnScreen();
    }
}


