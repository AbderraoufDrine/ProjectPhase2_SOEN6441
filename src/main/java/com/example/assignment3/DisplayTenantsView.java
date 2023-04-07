package com.example.assignment3;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.controllers.TenantController;
import com.example.assignment3.models.Tenant;

public class DisplayTenantsView {
    private final Stage stage;

    // Instantiate the TenantController
    private final TenantRepository tenantRepository;

    public DisplayTenantsView(Stage stage, TenantRepository tenantRepository) {
        this.stage = stage;
        this.tenantRepository = tenantRepository;

    }

    public void display() {

        TenantController tenantController= new TenantController(tenantRepository);
        // Get the list of tenants
        ArrayList<Tenant> tenants = tenantController.displayTenants();


        // Create the ListView to display the tenants
        ListView<String> tenantListView = new ListView<>();
        System.out.println("these are the the" + tenantController.displayTenants());
        // Loop through the array and add each tenant to the ListView
        for (Tenant tenant : tenants) {
            String tenantInfo = tenant.getName() + " - " + tenant.getEmail();
            tenantListView.getItems().add(tenantInfo);
        }

        // Create the button to refresh the list of tenants
        Button refreshTenantsBtn = new Button("Refresh");

        // Create the VBox to hold the ListView and button
        VBox displayTenantsBox = new VBox(10, tenantListView, refreshTenantsBtn);
        displayTenantsBox.setPadding(new Insets(10));

        // Add the VBox to the scene
        Stage tenantsStage = new Stage();
        Scene displayTenantScene = new Scene(displayTenantsBox);
        tenantsStage.setTitle("Tenants");
        tenantsStage.setScene(displayTenantScene);
        tenantsStage.initOwner(this.stage);
        tenantsStage.show();


        // Set the action for the refresh button
        refreshTenantsBtn.setOnAction(e -> {
            tenantListView.getItems().clear();
            ArrayList<Tenant> tenants2 = tenantController.displayTenants();

            for (Tenant tenant : tenants2) {
                String tenantInfo = tenant.getName() + " - " + tenant.getEmail();
                tenantListView.getItems().add(tenantInfo);
            }
        });
    }
}

