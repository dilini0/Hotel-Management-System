package com.xyz.blue.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane dashboardContext;
    public AnchorPane roomCDashboard;
    public AnchorPane manageRoomDashboard;
    public AnchorPane manageUsersDashboard;
    public AnchorPane reservationDashboard;
    public AnchorPane manageGuestsDashboard;

    public void initialize() {
        // Add event handler to roomCDashboard AnchorPane
        roomCDashboard.setOnMouseClicked(event -> {
            try {
                loadRoomCategoriesForm();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add event handler to manageRoomDashboard AnchorPane
        manageRoomDashboard.setOnMouseClicked(event -> {
            try {
                loadManageRoomDashboard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add event handler to manageUsersDashboard AnchorPane
        manageUsersDashboard.setOnMouseClicked(event -> {
            try {
                loadManageUsersDashboard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add event handler to reservationDashboard AnchorPane
        reservationDashboard.setOnMouseClicked(event -> {
            try {
                loadReservationDashboard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add event handler to manageGuestsDashboard AnchorPane
        manageGuestsDashboard.setOnMouseClicked(event -> {
            try {
                loadManageGuestsDashboard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void loadRoomCategoriesForm() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/RoomCategoriesForm.fxml"));
        AnchorPane roomCategoriesForm = loader.load();

        Stage stage = (Stage) dashboardContext.getScene().getWindow();
        stage.setScene(new Scene(roomCategoriesForm));
        stage.centerOnScreen();
    }

    private void loadManageRoomDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ManageRoomForm.fxml"));
        AnchorPane manageRoomDashboard = loader.load();

        Stage stage = (Stage) dashboardContext.getScene().getWindow();
        stage.setScene(new Scene(manageRoomDashboard));
        stage.centerOnScreen();
    }

    private void loadManageUsersDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ManageUsersForm.fxml"));
        AnchorPane manageUsersDashboard = loader.load();

        Stage stage = (Stage) dashboardContext.getScene().getWindow();
        stage.setScene(new Scene(manageUsersDashboard));
        stage.centerOnScreen();
    }

    private void loadReservationDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ManageReservationForm.fxml"));
        AnchorPane reservationDashboard = loader.load();

        Stage stage = (Stage) dashboardContext.getScene().getWindow();
        stage.setScene(new Scene(reservationDashboard));
        stage.centerOnScreen();
    }

    private void loadManageGuestsDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ManageGuestsForm.fxml"));
        AnchorPane manageGuestsDashboard = loader.load();

        Stage stage = (Stage) dashboardContext.getScene().getWindow();
        stage.setScene(new Scene(manageGuestsDashboard));
        stage.centerOnScreen();
    }
}
