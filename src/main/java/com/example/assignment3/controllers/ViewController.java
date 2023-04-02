package com.example.assignment3.controllers;

import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;

import java.text.ParseException;
import java.util.Scanner;

public class ViewController {
    LeaseRepository leaseRepository = new LeaseRepository();
    TenantRepository tenantRepository = new TenantRepository();
    RentalUnitRepository rentalUnitRepository = new RentalUnitRepository();

    TenantController  tenantController= new TenantController(tenantRepository);
    RentalUnitController rentalUnitController = new RentalUnitController(rentalUnitRepository,tenantRepository);
    LeaseController leaseController = new LeaseController(tenantRepository,rentalUnitRepository,leaseRepository);

    Scanner input = new Scanner(System.in);

    public void startProgram() {
        //TODO all the menu logic should be here

        int choice;

        System.out.println("Welcome to the Property Management System");
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Add a property");
            System.out.println("2. Add a tenant");
            System.out.println("3. Rent a unit");
            System.out.println("4. Display properties");
            System.out.println("5. Display tenants");
            System.out.println("6. Display rented units");
            System.out.println("7. Display vacant units");
            System.out.println("8. Display all leases");
            System.out.println("9. Exit");

            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    // add a property
                    int propertyChoiceAdd;
                    do {
                        System.out.println("Please select a property type to add:");
                        System.out.println("1. Apartment");
                        System.out.println("2. House");
                        System.out.println("3. Go back");

                        propertyChoiceAdd = Integer.parseInt(input.nextLine());

                        switch (propertyChoiceAdd) {
                            case 1:
                                // add an apartment
                                System.out.println("Please Enter the number of bedrooms:");
                                int numberBedrooms = Integer.parseInt(input.nextLine());
                                System.out.println("Please Enter the number of bathrooms:");
                                int numberBathrooms = Integer.parseInt(input.nextLine());
                                System.out.println("Please Enter the area:");
                                int area = Integer.parseInt(input.nextLine());
                                rentalUnitController.createRentalUnit("apartment",numberBedrooms,numberBathrooms,area);
                                break;

                            case 2:
                                System.out.println("Please Enter the number of bedrooms:");
                                int numberBedrooms_ = Integer.parseInt(input.nextLine());
                                System.out.println("Please Enter the number of bathrooms:");
                                int numberBathrooms_ = Integer.parseInt(input.nextLine());
                                System.out.println("Please Enter the area:");
                                int area_ = Integer.parseInt(input.nextLine());
                                rentalUnitController.createRentalUnit("house",numberBedrooms_,numberBathrooms_,area_);
                                break;
                            case 3:
                                System.out.println("Going back to main menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please select an option between 1-3.");
                                break;
                        }
                    } while (propertyChoiceAdd != 3);
                    break;
                case 2:
                    // add a tenant
                    System.out.println("Please enter the name of the tenant:");
                    String name = input.nextLine();
                    System.out.println("Please enter the email of the tenant:");
                    String email = input.nextLine();
                    tenantController.createTenant(name,email);
                    break;
                case 3:
                    // rent a unit
                    try {
                        System.out.println("Please enter the email of the tenant:");
                        String email_ = input.nextLine();
                        System.out.println("Please enter the rental unit ID:");
                        int id = Integer.parseInt(input.nextLine());
                        System.out.println("Please Enter the start date of the lease in the format dd/mm/yyyy:");
                        String startDate = input.nextLine();
                        System.out.println("Please Enter the end date of the lease in the format dd/mm/yyyy:");
                        String endDate = input.nextLine();
                        System.out.println("Please Enter the monthly rent of the lease:");
                        int rent = Integer.parseInt(input.nextLine());
                        leaseController.rentUnit(email_,id,startDate,endDate,rent);
                    }
                    catch (ParseException e)
                    {
                        System.out.println("Can't rent unit");
                    }
                    break;
                case 4:
                    rentalUnitController.displayAllUnits();
                    break;
                case 5:
                    // display tenants
                    tenantController.displayTenants();
                    break;
                case 6:
                    // display rented units
                    rentalUnitController.displayRentedUnits();
                    break;
                case 7:
                    // display vacant units
                    rentalUnitController.vacantUnits();
                    break;
                case 8:
                    // display all leases
                    leaseController.displayLeases();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select an option between 1-9.");
                    break;
            }
        } while (choice != 9);
    }
}


