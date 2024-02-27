package com.xyz.blue.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageReservationFormController {

    public AnchorPane reservationContext;
    public TableView tblReservation;
    public TableColumn txtRId;
    public TableColumn txtCId;
    public TableColumn txtRNo;
    public TableColumn txtPck;
    public TableColumn txtin;
    public TableColumn txtOut;
    public ComboBox comboPackages; //include Full Board, Half Board, Bed &Breakfast

    public void dateOutOnAction(ActionEvent actionEvent) {
    }

    public void dateInOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DashboardForm.fxml"));
            AnchorPane dashboardForm = loader.load();

            Stage stage = (Stage) reservationContext.getScene().getWindow();
            stage.setScene(new Scene(dashboardForm));
            stage.show();
        }
    }

