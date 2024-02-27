package com.xyz.blue.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomCategoryModel {
    // Dummy data for demonstration purposes
    private ObservableList<RoomCategory> roomCategories = FXCollections.observableArrayList();

    // Constructor
    public RoomCategoryModel() {
        // Initialize dummy data (you would replace this with actual data retrieval logic)
        roomCategories.add(new RoomCategory("1", "Single Room", "Description for Single Room"));
        roomCategories.add(new RoomCategory("2", "Twin Room", "Description for Double Room"));
        roomCategories.add(new RoomCategory("3", "Double Room", "Description for Suite"));
        roomCategories.add(new RoomCategory("4", "Triple Room", "Description for Single Room"));
        roomCategories.add(new RoomCategory("5", "Family Room", "Description for Double Room"));
        roomCategories.add(new RoomCategory("6", "VIP Room", "Description for Suite"));


    }

    // Method to get all room categories
    public ObservableList<RoomCategory> getAllRoomCategories() {
        return roomCategories;
    }

    // Method to add a new room category
    public void addRoomCategory(RoomCategory roomCategory) {
        roomCategories.add(roomCategory);
    }

    // Method to delete a room category
    public void deleteRoomCategory(RoomCategory roomCategory) {
        roomCategories.remove(roomCategory);
    }

    // Method to get a room category by ID
    public RoomCategory getRoomCategoryById(String id) {
        for (RoomCategory roomCategory : roomCategories) {
            if (roomCategory.getId().equals(id)) {
                return roomCategory;
            }
        }
        return null; // Room category not found
    }

    // Load room categories into table

    }



