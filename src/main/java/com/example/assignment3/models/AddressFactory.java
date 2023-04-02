package com.example.assignment3.models;

/**
 * This class is the address factory
 * that uses the factory pattern to instantiate the
 * address type object
 */

public class AddressFactory {

    /**
     * This method specified what type of
     * address we want to create
     * @return address object
     */
    public Address getInstance (String type){
        if(type.equals("apartment"))
            return new ApartmentAddress();
        else if(type.equals("house"))
            return new HouseAddress();
        return null;
    }
}
