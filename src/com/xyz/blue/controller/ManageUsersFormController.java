package com.xyz.blue.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageUsersFormController {

    public AnchorPane manageUserContext;
    public TableView tblManageUser;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colPhoneNo;
    public TableColumn colUserName;
    public TableColumn colpassword;
    public TextField txtName;
    public TextField txtPhoneNo;
    public TextField txtEmail;
    public TextField tctUserName;
    public TextField txtPassword;

    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DashboardForm.fxml"));
        AnchorPane dashboardForm = loader.load();

        Stage stage = (Stage) manageUserContext.getScene().getWindow();
        stage.setScene(new Scene(dashboardForm));
        stage.show();
    }
}
