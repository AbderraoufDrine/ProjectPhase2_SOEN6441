package com.example.assignment3.models;

/**
 * This class is the rental unit factory
 * that uses the factory pattern to instantiate the rental
 * unit object
 */
public class RentalUnitFactory {

    /**
     * This method specified what type of
     * rental unit we want to create
     * @return rental unit object
     */
    public RentalUnit getInstance(String type){
        if(type.equals("apartment"))
            return new Apartment();
        else if(type.equals("house"))
            return new House();
        return null;
    }
}
