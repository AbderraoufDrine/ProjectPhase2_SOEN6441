package com.example.assignment3;



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
        import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
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
        Button exitBtn = new Button("Exit");

        // Set the button sizes
        addPropertyBtn.setPrefSize(300, 50);
        addTenantBtn.setPrefSize(300, 50);
        rentUnitBtn.setPrefSize(300, 50);
        displayTenantsBtn.setPrefSize(300, 50);
        displayVacantUnitsBtn.setPrefSize(300, 50);
        displayRentedUnitsBtn.setPrefSize(300, 50);
        displayAllUnitsBtn.setPrefSize(300, 50);
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
        grid.add(exitBtn, 1, 2);

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
            Scene addPropertyScene = new Scene(addPropertyGrid, 500, 400);
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

            addPropertyGrid.add(new Label("Street Number:"), 0, 3);
            TextField propertyStreetNumberField = new TextField();
            addPropertyGrid.add(propertyStreetNumberField, 1, 3);

            addPropertyGrid.add(new Label("Street Name:"), 0, 4);
            TextField propertyStreetNameField = new TextField();
            addPropertyGrid.add(propertyStreetNameField, 1, 4);

            addPropertyGrid.add(new Label("City Name:"), 0, 5);
            TextField propertyCityField = new TextField();
            addPropertyGrid.add(propertyCityField, 1, 5);

            addPropertyGrid.add(new Label("Province Name:"), 0, 6);
            TextField propertyProvinceField = new TextField();
            addPropertyGrid.add(propertyProvinceField, 1, 6);

            addPropertyGrid.add(new Label("Postal Code:"), 0, 7);
            TextField propertyPostalCodeField = new TextField();
            addPropertyGrid.add(propertyPostalCodeField, 1, 7);

// Add the text field for Property Apartment
            addPropertyGrid.add(new Label("Unit Number:"), 0, 8);
            TextField propertyUnitNumberField = new TextField();
            addPropertyGrid.add(propertyUnitNumberField, 1, 8);

            // Show/hide the appropriate text field based on the selected radio button
            typeToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (typeToggleGroup.getSelectedToggle() == type1RadioBtn) {
                    propertyUnitNumberField.setVisible(true);
                } else if (typeToggleGroup.getSelectedToggle() == type2RadioBtn) {
                    propertyUnitNumberField.setVisible(false);
                }
            });

            // Add a button for adding the property
            Button submitBtn = new Button("Add Property");
            submitBtn.setOnAction(addPropertyEvent -> {
                // Get the property information from the text fields
                String propertyType = type1RadioBtn.isSelected() ? "Apartment" : "House";
                String propertyNumberBedrooms = propertyNumberBedroomsField.getText();
                String propertyNumberBathrooms = propertyNumberBathroomsField.getText();
                String propertyStreetNumber = propertyStreetNumberField.getText();
                String propertyStreetName = propertyStreetNameField.getText();
                String propertyCity = propertyCityField.getText();
                String propertyProvince = propertyProvinceField.getText();
                String propertyPostalCode = propertyPostalCodeField.getText();
                String propertyUnitNumber = propertyUnitNumberField.getText();

                // Add the property
                // ...

                // Close the add property window
                addPropertyStage.close();
            });

            addPropertyGrid.add(submitBtn, 1, 9);

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
                // Get the tenant information from the text fields
                String name = nameField.getText();
                String email = emailField.getText();

                // Add the new tenant to the system
                // ...

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
            TextField unitNumberField = new TextField();
            TextField tenantNameField = new TextField();
            rentUnitGrid.add(new Label("Unit Number:"), 0, 0);
            rentUnitGrid.add(unitNumberField, 1, 0);
            rentUnitGrid.add(new Label("Tenant Name:"), 0, 3);
            rentUnitGrid.add(tenantNameField, 1, 3);

            Button rentBtn = new Button("Rent");
            rentBtn.setOnAction(rentEvent -> {
                // Get the unit information from the text fields
                String unitNumber = unitNumberField.getText();
                String tenantName = tenantNameField.getText();

                // Rent the unit
                // ...

                // Close the rent unit window
                rentUnitStage.close();
            });
            rentUnitGrid.add(rentBtn, 1, 5);

        });


        // Handle exit button click event
        exitBtn.setOnAction(event -> primaryStage.close());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
