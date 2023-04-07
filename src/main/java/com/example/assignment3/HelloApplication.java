package com.example.assignment3;



import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.controllers.LeaseController;
import com.example.assignment3.controllers.RentalUnitController;
import com.example.assignment3.controllers.TenantController;
import com.example.assignment3.models.Lease;
import com.example.assignment3.models.RentalUnit;
import com.example.assignment3.models.Tenant;
import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
        import javafx.scene.layout.VBox;
        import javafx.scene.text.Font;
        import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        LeaseRepository leaseRepository = new LeaseRepository();
        TenantRepository tenantRepository = new TenantRepository();
        RentalUnitRepository rentalUnitRepository = new RentalUnitRepository();

        TenantController tenantController= new TenantController(tenantRepository);
        RentalUnitController rentalUnitController = new RentalUnitController(rentalUnitRepository,tenantRepository);
        LeaseController leaseController = new LeaseController(tenantRepository,rentalUnitRepository,leaseRepository);

        Scanner input = new Scanner(System.in);

        // Create a greeting message
        Text greeting = new Text("Welcome to My Property Management System!");
        greeting.setFont(Font.font("Arial", 20));

        // Create six buttons
        Button addPropertyBtn = new Button("Add Property");
        Button addTenantBtn = new Button("Add Tenant");
        Button rentUnitBtn = new Button("Rent Unit");
        Button displayTenantsBtn = new Button("Display Tenants");
        Button displayVacantUnitsBtn = new Button("Display VacantUnits");
        Button displayRentedUnitsBtn = new Button("Display RentedUnits");
        Button displayAllUnitsBtn = new Button("Display All Units");
        Button displayAllLeasesbtn = new Button("Display All Leases");
        Button exitBtn = new Button("Exit");

        // Set the button sizes
        addPropertyBtn.setPrefSize(300, 50);
        addTenantBtn.setPrefSize(300, 50);
        rentUnitBtn.setPrefSize(300, 50);
        displayTenantsBtn.setPrefSize(300, 50);
        displayVacantUnitsBtn.setPrefSize(300, 50);
        displayRentedUnitsBtn.setPrefSize(300, 50);
        displayAllUnitsBtn.setPrefSize(300, 50);
        displayAllLeasesbtn.setPrefSize(300, 50);
        exitBtn.setPrefSize(300, 50);

        // Create a grid pane to hold the buttons
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(addPropertyBtn, 0, 0);
        grid.add(addTenantBtn, 1, 0);
        grid.add(rentUnitBtn, 2, 0);
        grid.add(displayTenantsBtn, 0, 2);
        grid.add(displayVacantUnitsBtn, 0, 1);
        grid.add(displayRentedUnitsBtn, 1, 1);
        grid.add(displayAllUnitsBtn, 2, 1);
        grid.add(displayAllLeasesbtn, 1, 2);
        grid.add(exitBtn, 2, 2);

        // Create a VBox to hold the greeting message and the grid pane
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(greeting, grid);

        // Create a scene and add the VBox to it
        Scene scene = new Scene(vbox, 700, 400);

        // Set the stage title and scene, and show the stage
        primaryStage.setTitle("My Property Management System");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Style the buttons
        String buttonStyle = "-fx-background-color: #00bfff; -fx-text-fill: white; -fx-font-size: 18px;";
        addPropertyBtn.setStyle(buttonStyle);
        addTenantBtn.setStyle(buttonStyle);
        rentUnitBtn.setStyle(buttonStyle);
        displayTenantsBtn.setStyle(buttonStyle);
        displayVacantUnitsBtn.setStyle(buttonStyle);
        displayRentedUnitsBtn.setStyle(buttonStyle);
        displayAllUnitsBtn.setStyle(buttonStyle);
        displayAllLeasesbtn.setStyle(buttonStyle);
        exitBtn.setStyle(buttonStyle);


        // Handle add property button click event
        addPropertyBtn.setOnAction(event -> {

            // Create a toggle group for the radio buttons
            ToggleGroup typeToggleGroup = new ToggleGroup();

            // Create two radio buttons for the property types
            RadioButton type1RadioBtn = new RadioButton("Apartment");
            RadioButton type2RadioBtn = new RadioButton("House");
            type1RadioBtn.setToggleGroup(typeToggleGroup);
            type2RadioBtn.setToggleGroup(typeToggleGroup);

            // Create a grid pane for the add property form
            GridPane addPropertyGrid = new GridPane();
            addPropertyGrid.setAlignment(Pos.CENTER);
            addPropertyGrid.setHgap(10);
            addPropertyGrid.setVgap(10);
            addPropertyGrid.setPadding(new Insets(25, 25, 25, 25));

            // Create a new stage and scene for the add property window
            Scene addPropertyScene = new Scene(addPropertyGrid, 500, 450);
            Stage addPropertyStage = new Stage();
            addPropertyStage.setTitle("Add Property");
            addPropertyStage.setScene(addPropertyScene);
            addPropertyStage.show();

            // Add the radio buttons to the grid pane
            addPropertyGrid.add(new Label("Property Type:"), 0, 0);
            addPropertyGrid.add(type1RadioBtn, 1, 0);
            addPropertyGrid.add(type2RadioBtn, 2, 0);

            // Add labels and text fields for the property information
            addPropertyGrid.add(new Label("Number of Bedrooms:"), 0, 1);
            TextField propertyNumberBedroomsField = new TextField();
            addPropertyGrid.add(propertyNumberBedroomsField, 1, 1);

            addPropertyGrid.add(new Label("Number of Bathrooms:"), 0, 2);
            TextField propertyNumberBathroomsField = new TextField();
            addPropertyGrid.add(propertyNumberBathroomsField, 1, 2);

            addPropertyGrid.add(new Label("Area of unit:"), 0, 3);
            TextField unitAreaField = new TextField();
            addPropertyGrid.add(unitAreaField, 1, 3);

            addPropertyGrid.add(new Label("Street Number:"), 0, 4);
            TextField propertyStreetNumberField = new TextField();
            addPropertyGrid.add(propertyStreetNumberField, 1, 4);

            addPropertyGrid.add(new Label("Street Name:"), 0, 5);
            TextField propertyStreetNameField = new TextField();
            addPropertyGrid.add(propertyStreetNameField, 1, 5);

            addPropertyGrid.add(new Label("City Name:"), 0, 6);
            TextField propertyCityField = new TextField();
            addPropertyGrid.add(propertyCityField, 1, 6);

            addPropertyGrid.add(new Label("Province Name:"), 0, 7);
            TextField propertyProvinceField = new TextField();
            addPropertyGrid.add(propertyProvinceField, 1, 7);

            addPropertyGrid.add(new Label("Postal Code:"), 0, 8);
            TextField propertyPostalCodeField = new TextField();
            addPropertyGrid.add(propertyPostalCodeField, 1, 8);

            // Add the text field for Property Apartment
            addPropertyGrid.add(new Label("Unit Number:"), 0, 9);
            TextField propertyUnitNumberField = new TextField();
            addPropertyGrid.add(propertyUnitNumberField, 1, 9);


            // Show/hide the appropriate text field based on the selected radio button
            typeToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (typeToggleGroup.getSelectedToggle() == type1RadioBtn) {
                    propertyUnitNumberField.setVisible(true);
                } else if (typeToggleGroup.getSelectedToggle() == type2RadioBtn) {
                    propertyUnitNumberField.setVisible(false);
                }
            });

            //Select apartment radio button by default
            type1RadioBtn.setSelected(true);

            // Add a button for adding the property
            Button submitBtn = new Button("Add Property");
            submitBtn.setOnAction(addPropertyEvent -> {
                // Validate that all fields are filled in
                int propertyUnitNumber = 0;
                int propertyNumberBedrooms;
                int propertyNumberBathrooms;
                int area;
                int propertyStreetNumber;
                String propertyStreetName;
                String propertyCity;
                String propertyProvince;
                String propertyPostalCode;

                if ((propertyNumberBedroomsField.getText().isEmpty() || propertyNumberBathroomsField.getText().isEmpty() || propertyStreetNumberField.getText().isEmpty() || propertyStreetNameField.getText().isEmpty() || propertyCityField.getText().isEmpty() || propertyProvinceField.getText().isEmpty() || propertyPostalCodeField.getText().isEmpty())) {
                    // Show an error message and return
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill in all fields.");
                    alert.showAndWait();
                    return;
                }

                // Get the property information from the text fields
                try
                {
                    String propertyType = type1RadioBtn.isSelected() ? "apartment" : "house";
                    if(propertyType.equalsIgnoreCase("apartment"))
                    {
                        propertyNumberBedrooms = Integer.parseInt(propertyNumberBedroomsField.getText());
                        propertyNumberBathrooms = Integer.parseInt(propertyNumberBathroomsField.getText());
                        area = Integer.parseInt(unitAreaField.getText());
                        propertyStreetNumber = Integer.parseInt(propertyStreetNumberField.getText());
                        propertyStreetName = propertyStreetNameField.getText();
                        propertyCity = propertyCityField.getText();
                        propertyProvince = propertyProvinceField.getText();
                        propertyPostalCode = propertyPostalCodeField.getText();
                        propertyUnitNumber = Integer.parseInt(propertyUnitNumberField.getText());
                    }
                    else
                    {
                        propertyNumberBedrooms = Integer.parseInt(propertyNumberBedroomsField.getText());
                        propertyNumberBathrooms = Integer.parseInt(propertyNumberBathroomsField.getText());
                        area = Integer.parseInt(unitAreaField.getText());
                        propertyStreetNumber = Integer.parseInt(propertyStreetNumberField.getText());
                        propertyStreetName = propertyStreetNameField.getText();
                        propertyCity = propertyCityField.getText();
                        propertyProvince = propertyProvinceField.getText();
                        propertyPostalCode = propertyPostalCodeField.getText();
                    }

                    // Add the property
                    rentalUnitController.createRentalUnit(propertyType,propertyNumberBedrooms,propertyNumberBathrooms,area,propertyStreetNumber,propertyStreetName,propertyCity,propertyProvince,propertyPostalCode,propertyUnitNumber);
                }
                catch (Exception e)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error - wrong type of fields");
                    alert.setHeaderText("Please make sure that you entered all fields correctly");
                    alert.showAndWait();
                    return;
                }



                // Close the add property window
                addPropertyStage.close();
            });

            addPropertyGrid.add(submitBtn, 1, 10);

        });


        // Handle add tenant button click event
        addTenantBtn.setOnAction(event -> {
            // Create a grid pane for the add tenant form
            GridPane addTenantGrid = new GridPane();
            addTenantGrid.setAlignment(Pos.CENTER);
            addTenantGrid.setHgap(10);
            addTenantGrid.setVgap(10);
            addTenantGrid.setPadding(new Insets(25, 25, 25, 25));

            // Create a new stage and scene for the add tenant window
            Scene addTenantScene = new Scene(addTenantGrid, 400, 300);
            Stage addTenantStage = new Stage();
            addTenantStage.setTitle("Add Tenant");
            addTenantStage.setScene(addTenantScene);
            addTenantStage.show();

            // Add text fields for the tenant information
            TextField nameField = new TextField();
            TextField emailField = new TextField();
            addTenantGrid.add(new Label("Name:"), 0, 0);
            addTenantGrid.add(nameField, 1, 0);
            addTenantGrid.add(new Label("Email:"), 0, 3);
            addTenantGrid.add(emailField, 1, 3);

            // Add a submit button to add the new tenant
            Button submitBtn = new Button("Submit");
            submitBtn.setOnAction(submitEvent -> {
                // Validate that all fields are filled in
                if (nameField.getText().isEmpty() || emailField.getText().isEmpty()) {
                    // Show an error message and return
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill in all fields.");
                    alert.showAndWait();
                    return;
                }

                // Get the tenant information from the text fields
                String name = nameField.getText();
                String email = emailField.getText();


                // Add the new tenant to the system
                tenantController.createTenant(name,email);

                // Close the add tenant window
                addTenantStage.close();
            });
            addTenantGrid.add(submitBtn, 1, 5);
        });

        rentUnitBtn.setOnAction(event -> {
            // Code to rent a unit

            // Create a grid pane for the rent a unit form
            GridPane rentUnitGrid = new GridPane();
            rentUnitGrid.setAlignment(Pos.CENTER);
            rentUnitGrid.setHgap(10);
            rentUnitGrid.setVgap(10);
            rentUnitGrid.setPadding(new Insets(25, 25, 25, 25));

            // Create a new stage and scene for rent a unit window
            Scene rentUnitScene = new Scene(rentUnitGrid, 400, 300);
            Stage rentUnitStage = new Stage();
            rentUnitStage.setTitle("Rent Unit");
            rentUnitStage.setScene(rentUnitScene);
            rentUnitStage.show();

            // Add text fields for the renting information
            TextField emailField = new TextField();
            TextField rentalUnitField = new TextField();
            TextField leaseField = new TextField();
            DatePicker startDate = new DatePicker();
            DatePicker endDate = new DatePicker();
            rentUnitGrid.add(new Label("Tenant email:"), 0, 0);
            rentUnitGrid.add(emailField, 1, 0);
            rentUnitGrid.add(new Label("Rental Unit ID:"), 0, 1);
            rentUnitGrid.add(rentalUnitField, 1, 1);
            rentUnitGrid.add(new Label("Lease amount per month:"), 0, 2);
            rentUnitGrid.add(leaseField, 1, 2);
            rentUnitGrid.add(new Label("Start Date:"), 0, 3);
            rentUnitGrid.add(startDate, 1, 3);
            rentUnitGrid.add(new Label("End Date:"), 0, 4);
            rentUnitGrid.add(endDate, 1, 4);

            Button rentBtn = new Button("Rent");
            rentBtn.setOnAction(rentEvent -> {
                // Validate that all fields are filled in
                if (emailField.getText().isEmpty() || rentalUnitField.getText().isEmpty() || leaseField.getText().isEmpty() || startDate.getValue() == null || endDate.getValue() == null) {
                    // Show an error message and return
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill in all fields.");
                    alert.showAndWait();
                    return;
                }


                // Define the formatter for the new date format
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                // Get the unit information from the text fields and date pickers
                String email = emailField.getText();
                int rentalUnit = Integer.parseInt(rentalUnitField.getText());
                int rent = Integer.parseInt(leaseField.getText());
                String start = startDate.getValue().format(dateFormatter);
                String end = endDate.getValue().format(dateFormatter);



                // Rent the unit
                try
                {
                    System.out.println(start);
                    leaseController.rentUnit(email,rentalUnit,start,end,rent);
                }
                catch (ParseException e)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error - Unit not available");
                    alert.setHeaderText("Unable to rent unit");
                    alert.showAndWait();
                    return;
                }

                // Close the rent unit window
                rentUnitStage.close();
            });
            rentUnitGrid.add(rentBtn, 1, 5);

        });

        displayTenantsBtn.setOnAction(e -> {

            DisplayTenantsView displayTenantsView = new DisplayTenantsView(primaryStage);
            displayTenantsView.display();

        });

        displayAllUnitsBtn.setOnAction(e -> {

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



            // Create a new stage to show the tenants list
            Stage rentalUnitStage = new Stage();
            rentalUnitStage.setTitle("All Units");
            //rentalUnitStage.initModality(Modality.APPLICATION_MODAL);
            rentalUnitStage.initOwner(primaryStage);
            rentalUnitStage.setScene(new Scene(Box, 650, 325));
            rentalUnitStage.show();
        });


        displayVacantUnitsBtn.setOnAction(e -> {

            ArrayList<RentalUnit> vacantUnits = rentalUnitController.vacantUnits();
            // Create the ListView to display the tenants
            ListView<String> vacantRentalUnitListView = new ListView<>();

            // Clear the ListView
            vacantRentalUnitListView.getItems().clear();

            // Loop through the array and add each tenant to the ListView
            for (RentalUnit unit : vacantUnits) {
                String unitInfo = unit.toString();
                vacantRentalUnitListView.getItems().add(unitInfo);
            }

            // Create the button to refresh the list of tenants
            Button refreshTenantsBtn = new Button("Refresh");

            // Create a VBox to hold the ListView and the Refresh button
            VBox Box = new VBox(10, vacantRentalUnitListView, refreshTenantsBtn);
            Box.setPadding(new Insets(10));

            // Add event handler to the Refresh button
            refreshTenantsBtn.setOnAction(event -> {
                // Clear the ListView
                vacantRentalUnitListView.getItems().clear();

                // Refresh the list of tenants and add them to the ListView
                ArrayList<RentalUnit> vacantUnits2 = rentalUnitController.vacantUnits();
                for (RentalUnit unit : vacantUnits2) {
                    String unitInfo = unit.toString();
                    vacantRentalUnitListView.getItems().add(unitInfo);
                }
            });

            // Create a new stage to show the tenants list
            Stage rentalUnitStage = new Stage();
            rentalUnitStage.setTitle("All Units");
            //rentalUnitStage.initModality(Modality.APPLICATION_MODAL);
            rentalUnitStage.initOwner(primaryStage);
            rentalUnitStage.setScene(new Scene(Box, 650, 325));
            rentalUnitStage.show();
        });

        displayRentedUnitsBtn.setOnAction(e -> {

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

            // Create a new stage to show the tenants list
            Stage rentalUnitStage = new Stage();
            rentalUnitStage.setTitle("All Units");
            //rentalUnitStage.initModality(Modality.APPLICATION_MODAL);
            rentalUnitStage.initOwner(primaryStage);
            rentalUnitStage.setScene(new Scene(Box, 650, 325));
            rentalUnitStage.show();
        });

        displayAllLeasesbtn.setOnAction(e -> {

            ArrayList<Lease> leases = leaseController.displayLeases();
            // Create the ListView to display the tenants
            ListView<String> leaseListView = new ListView<>();

            // Clear the ListView
            leaseListView.getItems().clear();

            // Loop through the array and add each tenant to the ListView
            for (Lease lease : leases) {
                String leaseInfo = lease.toString();
                leaseListView.getItems().add(leaseInfo);
            }

            // Create the button to refresh the list of tenants
            Button refreshTenantsBtn = new Button("Refresh");

            // Create a VBox to hold the ListView and the Refresh button
            VBox Box = new VBox(10, leaseListView, refreshTenantsBtn);
            Box.setPadding(new Insets(10));

            // Add event handler to the Refresh button
            refreshTenantsBtn.setOnAction(event -> {
                // Clear the ListView
                leaseListView.getItems().clear();

                // Refresh the list of tenants and add them to the ListView
                ArrayList<Lease> leases2 = leaseController.displayLeases();

                for (Lease lease : leases2) {
                    String leaseInfo = lease.toString();
                    leaseListView.getItems().add(leaseInfo);
                }
            });

            // Create a new stage to show the tenants list
            Stage rentalUnitStage = new Stage();
            rentalUnitStage.setTitle("All Units");
            //rentalUnitStage.initModality(Modality.APPLICATION_MODAL);
            rentalUnitStage.initOwner(primaryStage);
            rentalUnitStage.setScene(new Scene(Box, 650, 325));
            rentalUnitStage.show();
        });


        // Handle exit button click event
        exitBtn.setOnAction(event -> primaryStage.close());
    }
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
