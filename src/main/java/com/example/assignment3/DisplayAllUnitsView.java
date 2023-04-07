package com.example.assignment3;

import java.util.ArrayList;

import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.controllers.RentalUnitController;
import com.example.assignment3.models.RentalUnit;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayAllUnitsView {
    private final Stage stage;
    private final TenantRepository tenantRepository;
    private final RentalUnitRepository rentalUnitRepository;

    public DisplayAllUnitsView(Stage stage,TenantRepository tenantRepository,RentalUnitRepository rentalUnitRepository)
    {
        this.stage = stage;
        this.rentalUnitRepository = rentalUnitRepository;
        this.tenantRepository = tenantRepository;
    }

    public void display() {

        Thread thread = new Thread(() -> {

            // Instantiate the TenantController
            RentalUnitController rentalUnitController = new RentalUnitController(rentalUnitRepository, tenantRepository);

            // Get the list of tenants
            ArrayList<RentalUnit> units = rentalUnitController.displayAllUnits();

            // Create the ListView to display the tenants
            ListView<String> rentalUnitListView = new ListView<>();

            // Clear the ListView
            rentalUnitListView.getItems().clear();

            // Loop through the array and add each tenant to the ListView
            for (RentalUnit unit : units) {
                String unitInfo = unit.toString();
                rentalUnitListView.getItems().add(unitInfo);
            }

            // Create the button to refresh the list of tenants
            Button refreshTenantsBtn = new Button("Refresh");

            // Create a VBox to hold the ListView and the Refresh button
            VBox Box = new VBox(10, rentalUnitListView, refreshTenantsBtn);
            Box.setPadding(new Insets(10));

            // Create a new stage to show the tenants list
            Platform.runLater(()->{
            Stage rentalUnitStage = new Stage();
            rentalUnitStage.setTitle("All Units");
            //rentalUnitStage.initModality(Modality.APPLICATION_MODAL);
            rentalUnitStage.initOwner(this.stage);
            rentalUnitStage.setScene(new Scene(Box, 650, 325));
            rentalUnitStage.show();
            });

            // Add event handler to the Refresh button
            refreshTenantsBtn.setOnAction(event -> {
                // Clear the ListView
                rentalUnitListView.getItems().clear();
                // Refresh the list of tenants and add them to the ListView
                ArrayList<RentalUnit> units2 = rentalUnitController.displayAllUnits();
                for (RentalUnit unit : units2) {
                    String unitInfo = unit.toString();
                    rentalUnitListView.getItems().add(unitInfo);
                }
            });
        });
        thread.setDaemon(true);
        thread.start();
    }
}
