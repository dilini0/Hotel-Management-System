package com.xyz.blue.controller;

import com.xyz.blue.model.Guest;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageGuestsFormController {
    public AnchorPane manageGuestsContext;
    public TableView<Guest> tblManageGuests;
    @FXML
    public TableColumn<Guest, Integer> colId;
    @FXML
    public TableColumn<Guest, String> colName;
    @FXML
    public TableColumn<Guest, String> colAddress;
    @FXML
    public TableColumn<Guest, String> colPhoneNo;
    public TextField txtId;
    public TextField txtAddeas;
    public TextField txtName;
    public TextField txtPhoneNo;


    public void saveOnAction(ActionEvent actionEvent) {
        // Retrieve data from text fields
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String address = txtAddeas.getText();
        String phoneNo = txtPhoneNo.getText();

        // Create a new Guest object
        Guest guest = new Guest(id, name, address, phoneNo);

        // Add the new guest to the table
        tblManageGuests.getItems().add(guest);

        // Clear text fields after saving
       // clearTextFields();

    }

    public void deleteOnAction(ActionEvent actionEvent) {
        Guest selectedGuest = tblManageGuests.getSelectionModel().getSelectedItem();

        if (selectedGuest != null) {
            // Remove the selected guest from the table
            tblManageGuests.getItems().remove(selectedGuest);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        // Get selected guest from the table
        Guest selectedGuest = tblManageGuests.getSelectionModel().getSelectedItem();

        if (selectedGuest != null) {
            // Update selected guest with new data from text fields
            selectedGuest.setName(txtName.getText());
            selectedGuest.setAddress(txtAddeas.getText());
            selectedGuest.setPhoneNo(txtPhoneNo.getText());

            // Refresh table view to reflect changes
            tblManageGuests.refresh();

            // Clear text fields after updating
            clearTextFields();
        }
    }

    public void serchOnAction(ActionEvent actionEvent) {
        // Retrieve search criteria from text fields
        String searchText = txtName.getText().trim(); // For example, search by name

        // Filter guests based on search criteria
        ObservableList<Guest> filteredGuests = tblManageGuests.getItems().filtered(guest -> guest.getName().equalsIgnoreCase(searchText));

        // Update table view with filtered guests
        tblManageGuests.setItems(filteredGuests);

        // Clear text fields after searching
        clearTextFields();

    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DashboardForm.fxml"));
        AnchorPane dashboardForm = loader.load();

        Stage stage = (Stage) manageGuestsContext.getScene().getWindow();
        stage.setScene(new Scene(dashboardForm));
        stage.show();
    }

    // Method to clear text fields
    private void clearTextFields() {
        txtId.clear();
        txtName.clear();
        txtAddeas.clear();
        txtPhoneNo.clear();
    }
}
