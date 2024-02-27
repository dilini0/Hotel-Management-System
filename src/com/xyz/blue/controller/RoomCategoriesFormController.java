package com.xyz.blue.controller;

import com.xyz.blue.model.RoomCategory;
import com.xyz.blue.model.RoomCategoryModel;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomCategoriesFormController {
    @FXML
    private AnchorPane roomCategoriesContext;
    @FXML
    private TableView<RoomCategory> tblRoomCategories;
    @FXML
    private TableColumn<RoomCategory, String> colId;
    @FXML
    private TableColumn<RoomCategory, String> colName;
    @FXML
    private TableColumn<RoomCategory, String> colDescription;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtname;
    @FXML
    private TextField textDescription;
    @FXML
    private Button btn;
    @FXML
    private Button srchbtn;
    @FXML
    private TextField textSerarchId;

    // Reference to the model
    private RoomCategoryModel roomCategoryModel;
    private JFXPanel dashboardContext;





    // Initialize the controller
    public void initialize() {
        // Initialize the model
        roomCategoryModel = new RoomCategoryModel();

        // Set cell value factories for table columns
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Load room categories into table
        loadRoomCategories();

        // Handle table row selection
        tblRoomCategories.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtId.setText(newValue.getId());
                txtname.setText(newValue.getName());
                textDescription.setText(newValue.getDescription());
            }
        });
    }

    // Method to load room categories into table
    private void loadRoomCategories() {
        ObservableList<RoomCategory> roomCategories = roomCategoryModel.getAllRoomCategories();
        tblRoomCategories.setItems(roomCategories);
    }

    // Handle delete button action
    public void deleteOnAction(ActionEvent actionEvent) {
        RoomCategory selectedRoomCategory = tblRoomCategories.getSelectionModel().getSelectedItem();
        if (selectedRoomCategory != null) {
            roomCategoryModel.deleteRoomCategory(selectedRoomCategory);
            loadRoomCategories();
            clearFields();
        } else {
            showAlert("Please select a room category to delete.");
        }
    }

    // Handle back to home button action
    // Handle back to home button action
    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DashboardForm.fxml"));
        AnchorPane dashboardForm = loader.load();

        Stage stage = (Stage) roomCategoriesContext.getScene().getWindow();
        stage.setScene(new Scene(dashboardForm));
        stage.show();
    }






    // Handle search button action
    public void serchOnAction(ActionEvent actionEvent) {
        String searchId = textSerarchId.getText().trim();
        if (!searchId.isEmpty()) {
            RoomCategory roomCategory = roomCategoryModel.getRoomCategoryById(searchId);
            if (roomCategory != null) {
                txtId.setText(roomCategory.getId());
                txtname.setText(roomCategory.getName());
                textDescription.setText(roomCategory.getDescription());
            } else {
                showAlert("Room category not found for ID: " + searchId);
            }
        } else {
            showAlert("Please enter a room category ID to search.");
        }
    }

    // Handle add new category button action
    public void addNewCtegoryOnAction(ActionEvent actionEvent) {
        String id = txtId.getText().trim();
        String name = txtname.getText().trim();
        String description = textDescription.getText().trim();

        if (!id.isEmpty() && !name.isEmpty() && !description.isEmpty()) {
            RoomCategory newRoomCategory = new RoomCategory(id, name, description);
            roomCategoryModel.addRoomCategory(newRoomCategory);
            loadRoomCategories();
            clearFields();
        } else {
            showAlert("Please enter values for ID, Name, and Description.");
        }
    }

    // Method to clear text fields
    private void clearFields() {
        txtId.clear();
        txtname.clear();
        textDescription.clear();
    }

    // Method to show alert dialog
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

