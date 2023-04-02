package com.example.assignment3.controllers;

import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.models.*;

import java.util.ArrayList;

/**
 * This is the rental units controller
 * which performs every operation
 * regarding the units
 */
public class RentalUnitController {
    private RentalUnitFactory factory;
    private AddressFactory adFactory;

    Observer observer;

    RentalUnitRepository repository;

    TenantRepository tenantRepository;

    /**
     * Constructor
     */
    public RentalUnitController(RentalUnitRepository obj, TenantRepository tenantRepository){
        repository = obj;
        factory = new RentalUnitFactory();
        adFactory = new AddressFactory();
        observer = new Observer();
        this.tenantRepository = tenantRepository;
    }

    /**
     * create a unit and
     * store it in the database
     */
    public void createRentalUnit (String type, int numOfBed, int numOfBath, int area){
        try {
            RentalUnit obj = null;
            obj = factory.getInstance(type);
            obj.setAddress(adFactory.getInstance(type));
            obj.getAddress().BuildAddress();
            obj.setBedrooms(numOfBed);
            obj.setBathrooms(numOfBath);
            obj.setArea(area);
            obj.setRented(false);
            repository.save(obj);
            System.out.println("Rental unit has been created");
            System.out.println(obj);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

    /**
     * @return  a unit
     * from the database by
     * searching its ID
     */
    public RentalUnit getRentalUnit(int Id){
        return repository.get(Id);
    }

    /**
     * @return a string indicating if
     * a unit has been deleted or not
     */
    public String removeRentalUnit(int Id){
        RentalUnit obj = getRentalUnit(Id);
        if(repository.delete(obj))
            return ("The unit has been deleted");
        else
            return ("It seems there is no unit with this ID");
    }

    /**
     * @return a string indicating if
     * a unit rented property has been
     * changed or not
     */
    public String changeRented(int Id, String state){
        boolean outcome = false;
        if(state.equals("rent"))
            outcome = repository.update(Id,true);
        else if(state.equals("vacant")) {
            outcome = repository.update(Id, false);
            ArrayList<String> list = observer.getRegistered();
            for(String a: list){
                String []parts = a.split(" ");
                if(Integer.parseInt(parts[1]) == Id)
                    observer.send(Id);
            }
        }

        if(outcome)
            return ("The type of RentalUnit is changed");
        else
            return ("We can't change the type at the moment");
    }

    /**
     * display all the units in the database
     */
    public void displayAllUnits(){
        try {
            for (RentalUnit r : repository.getAll())
                System.out.println(r);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

    /**
     * display all the rented units in the database
     */
    public void displayRentedUnits(){
        try {
            for (RentalUnit r : repository.getAllRented())
                System.out.println(r);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

    /**
     * display all the vacant units in the database
     */
    public void vacantUnits(){
        try {
            for (RentalUnit r : repository.getAllVacant())
                System.out.println(r);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

    /**
     * Register the tenants that
     * want to check if a unit became vacant or not
     */
    public void RegisterTenant(int Id, String email){
        try {
            RentalUnit obj = repository.getUnit(Id);
            Tenant tenant = tenantRepository.get(email);
            observer.subscribe(tenant, obj);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }
    }


}
