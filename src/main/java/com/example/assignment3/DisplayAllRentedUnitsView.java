package com.example.assignment3;

import java.util.ArrayList;

import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.controllers.LeaseController;
import com.example.assignment3.controllers.RentalUnitController;
import com.example.assignment3.models.RentalUnit;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.controllers.TenantController;
import com.example.assignment3.models.Tenant;

public class DisplayAllRentedUnitsView {
    private Stage stage;
    private final TenantRepository tenantRepository;
    private final RentalUnitRepository rentalUnitRepository;

    public DisplayAllRentedUnitsView(Stage stage,TenantRepository tenantRepository,RentalUnitRepository rentalUnitRepository)
    {
        this.stage = stage;
        this.rentalUnitRepository = rentalUnitRepository;
        this.tenantRepository = tenantRepository;
    }

    public void display() {

        // Instantiate the TenantController
        RentalUnitController rentalUnitController = new RentalUnitController(rentalUnitRepository,tenantRepository);

        ArrayList<RentalUnit> rentedUnits = rentalUnitController.displayRentedUnits();
        // Create the ListView to display the tenants
        ListView<String> rentedRentalUnitListView = new ListView<>();

        // Clear the ListView
        rentedRentalUnitListView.getItems().clear();


        // Loop through the array and add each tenant to the ListView
        for (RentalUnit unit : rentedUnits) {
            String unitInfo = unit.toString();
            rentedRentalUnitListView.getItems().add(unitInfo);
        }

        // Create the button to refresh the list of tenants
        Button refreshTenantsBtn = new Button("Refresh");

        // Create a VBox to hold the ListView and the Refresh button
        VBox Box = new VBox(10, rentedRentalUnitListView, refreshTenantsBtn);
        Box.setPadding(new Insets(10));

        // Create a new stage to show the tenants list
        Stage rentalUnitStage = new Stage();
        rentalUnitStage.setTitle("All Rented Units");
        rentalUnitStage.initOwner(this.stage);
        rentalUnitStage.setScene(new Scene(Box, 650, 325));
        rentalUnitStage.show();


        // Add event handler to the Refresh button
        refreshTenantsBtn.setOnAction(event -> {
            // Clear the ListView
            rentedRentalUnitListView.getItems().clear();

            // Refresh the list of tenants and add them to the ListView
            ArrayList<RentalUnit> rentedUnits2 = rentalUnitController.displayRentedUnits();

            for (RentalUnit unit : rentedUnits2) {
                String unitInfo = unit.toString();
                rentedRentalUnitListView.getItems().add(unitInfo);
            }
        });

    }
}
