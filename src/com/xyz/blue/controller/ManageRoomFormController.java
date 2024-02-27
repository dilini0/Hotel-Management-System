package com.xyz.blue.controller;

import com.xyz.blue.model.Room;
import com.xyz.blue.model.RoomCategoryModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageRoomFormController {


        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bluebird";
        private static final String USERNAME = "your_username";
        private static final String PASSWORD = "your_password";


    // Establish database connection
        private Connection connection;


    public ManageRoomFormController() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadRoomDataFromDatabase() {
        ObservableList<Room> rooms = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM rooms";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String roomNo = resultSet.getString("room_no");
                String roomType = resultSet.getString("room_type");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                Room room = new Room(roomNo, roomType, price, status);
                rooms.add(room);
            }
            tblRoomManage.setItems(rooms);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @FXML
    private AnchorPane manageRoomContext;
    @FXML
    private TableView<Room> tblRoomManage;
    @FXML
    private TableColumn<Room, String> colRoomNo;
    @FXML
    private TableColumn<Room, String> colRoomType;
    @FXML
    private TableColumn<Room, Double> colRoomPrice;
    @FXML
    private TableColumn<Room, String> colStatus;
    @FXML
    private TextField txtRoomNo;
    @FXML
    private TextField txtPrice;
    @FXML
    private ComboBox<String> comboname;
    @FXML
    private ComboBox<String> comboStatus;





    // Method to initialize the controller
    public void initialize() {
        // Set up table columns
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colRoomPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Sample data for combo boxes
        ObservableList<String> roomTypes = FXCollections.observableArrayList("Single", "Double", "Suite");
        comboname.setItems(roomTypes);

        ObservableList<String> statuses = FXCollections.observableArrayList("Available", "Occupied", "Maintenance");
        comboStatus.setItems(statuses);

        // Load sample data into table for demonstration
        loadSampleData();
    }

    // Method to load sample data into table (for demonstration)
    private void loadSampleData() {
        ObservableList<Room> rooms = FXCollections.observableArrayList(
                new Room("101", "Single", 100.0, "Available"),
                new Room("102", "Double", 150.0, "Occupied"),
                new Room("103", "Suite", 200.0, "Maintenance")
        );
        tblRoomManage.setItems(rooms);
    }

    // Handle save button action
    @FXML
    public void saveOnAction(ActionEvent actionEvent) {
        // Implement logic to save room data
        String roomNo = txtRoomNo.getText();
        String roomType = comboname.getValue();
        double price = Double.parseDouble(txtPrice.getText());
        String status = comboStatus.getValue();

        Room newRoom = new Room(roomNo, roomType, price, status);
        tblRoomManage.getItems().add(newRoom);

        // Clear input fields after adding
        txtRoomNo.clear();
        txtPrice.clear();
        comboname.getSelectionModel().clearSelection();
        comboStatus.getSelectionModel().clearSelection();

    }

    // Handle delete button action
    @FXML
    public void deleteOnAction(ActionEvent actionEvent) {
        // Implement logic to delete room data
        // Get the selected room from the TableView
        Room selectedRoom = tblRoomManage.getSelectionModel().getSelectedItem();

        if (selectedRoom != null) {
            // Remove the selected room from the TableView
            tblRoomManage.getItems().remove(selectedRoom);
        } else {
            // If no room is selected, display an error message or handle it accordingly
            System.out.println("Please select a room to delete.");
            // You can also show an alert or display a message to the user
        }
    }

    // Handle update button action
    @FXML
    public void updateOnAction(ActionEvent actionEvent) {
        // Implement logic to update room data
        Room selectedRoom = tblRoomManage.getSelectionModel().getSelectedItem();

        if (selectedRoom != null) {
            // Update the attributes of the selected room based on user input
            String roomNo = txtRoomNo.getText();
            String roomType = comboname.getValue();
            double price = Double.parseDouble(txtPrice.getText());
            String status = comboStatus.getValue();

            // Update the selected room with new values
            selectedRoom.setRoomNo(roomNo);
            selectedRoom.setRoomType(roomType);
            selectedRoom.setPrice(price);
            selectedRoom.setStatus(status);

            // Refresh TableView to reflect changes
            tblRoomManage.refresh();

            // Clear input fields after updating
            txtRoomNo.clear();
            txtPrice.clear();
            comboname.getSelectionModel().clearSelection();
            comboStatus.getSelectionModel().clearSelection();
        } else {
            // If no room is selected, display an error message or handle it accordingly
            System.out.println("Please select a room to update.");
            // You can also show an alert or display a message to the user
        }
    }

    // Handle search button action
    @FXML
    public void serchOnAction(ActionEvent actionEvent) {
        // Implement logic to search for room data
        String searchText = txtRoomNo.getText().trim(); // You can search by room number or any other criteria

        // Filter the rooms based on the search criteria
        ObservableList<Room> filteredRooms = FXCollections.observableArrayList();
        for (Room room : tblRoomManage.getItems()) {
            // Here you can define your search logic, for example, searching by room number
            if (room.getRoomNo().equalsIgnoreCase(searchText)) {
                filteredRooms.add(room);
            }
        }

        // Update the TableView with the filtered rooms
        tblRoomManage.setItems(filteredRooms);

        // Clear input fields after searching
        txtRoomNo.clear();
        txtPrice.clear();
        comboname.getSelectionModel().clearSelection();
        comboStatus.getSelectionModel().clearSelection();

        // You might also want to handle the case where no rooms match the search criteria
        if (filteredRooms.isEmpty()) {
            // Display a message to the user indicating no matching rooms found
            System.out.println("No rooms found matching the search criteria.");
            // You can also show an alert or display a message to the user
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DashboardForm.fxml"));
        AnchorPane dashboardForm = loader.load();

        Stage stage = (Stage) manageRoomContext.getScene().getWindow();
        stage.setScene(new Scene(dashboardForm));
        stage.show();
    }
}
