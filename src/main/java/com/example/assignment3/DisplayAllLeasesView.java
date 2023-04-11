package com.example.assignment3;

import java.util.ArrayList;

import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.controllers.LeaseController;
import com.example.assignment3.controllers.RentalUnitController;
import com.example.assignment3.models.Lease;
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

public class DisplayAllLeasesView {
    private Stage stage;
    private final LeaseRepository leaseRepository;
    private final TenantRepository tenantRepository;

    public DisplayAllLeasesView(Stage stage,TenantRepository tenantRepository,LeaseRepository leaseRepository)
    {
        this.stage = stage;
        this.leaseRepository = leaseRepository;
        this.tenantRepository = tenantRepository;
    }

    public void display() {

        // Instantiate the TenantController
        RentalUnitRepository rentalUnitRepository = new RentalUnitRepository();
        LeaseController leaseController = new LeaseController(tenantRepository,rentalUnitRepository,leaseRepository);


        ArrayList<Lease> leases = leaseController.displayLeases();

        // Create the ListView to display the tenants
        ListView<String> leaseListView = new ListView<>();

        // Clear the ListView
        leaseListView.getItems().clear();

        // Loop through the array and add each tenant to the ListView
        for (Lease lease : leases) {
            String leaseInfo = "Tenant " + lease.getTenant().getName() + " is renting unit id " + lease.getRentalUnit().getId() + " for "
                    + lease.getPrice() + "CAD" + " from " + lease.getStartDate() + " till" + lease.getEndDate();
            leaseListView.getItems().add(leaseInfo);
        }

        // Create the button to refresh the list of tenants
        Button refreshTenantsBtn = new Button("Refresh");

        // Create a VBox to hold the ListView and the Refresh button
        VBox Box = new VBox(10, leaseListView, refreshTenantsBtn);
        Box.setPadding(new Insets(10));

        // Create a new stage to show the tenants list
        Stage rentalUnitStage = new Stage();
        rentalUnitStage.setTitle("Leases");
        rentalUnitStage.initOwner(this.stage);
        rentalUnitStage.setScene(new Scene(Box, 650, 325));
        rentalUnitStage.show();

        // Add event handler to the Refresh button
        refreshTenantsBtn.setOnAction(event -> {
            // Clear the ListView
            leaseListView.getItems().clear();

            // Refresh the list of tenants and add them to the ListView
            ArrayList<Lease> leases2 = leaseController.displayLeases();

            for (Lease lease : leases2) {
                String leaseInfo = "Tenant " + lease.getTenant().getName() + " is renting unit id " + lease.getRentalUnit().getId() + " for "
                        + lease.getPrice() + "CAD" + " from " + " " + lease.getStartDate().toString() + " till " + lease.getEndDate().toString();
                leaseListView.getItems().add(leaseInfo);
            }
        });
    }
}
