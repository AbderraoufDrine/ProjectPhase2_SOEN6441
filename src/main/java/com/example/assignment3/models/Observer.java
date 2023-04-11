package com.example.assignment3.models;

import java.util.ArrayList;

/**
 * This class is the Observer
 * that uses the observer pattern to send
 * emails to tenants who are interested in
 * unit
 */
public class Observer {
    private ArrayList<String> potentialTenants;

    /**
     * Constructor
     */
    public Observer(){
        potentialTenants = new ArrayList<>();
    }

    /**
     * Add the tenant into the sevice
     */
    public void subscribe(Tenant obj, RentalUnit rentalUnit){
        potentialTenants.add(obj.getEmail()+" "+rentalUnit.getId());
    }

    /**
     * send emails to all tenants
     * who are interested in the unit
     */
    public void send(int Id){
        for(String s: potentialTenants) {
            String []parts = s.split(" ");
            if(Id == Integer.parseInt(parts[1]))
            System.out.println("An email has been sent to " + s);
        }
    }

    /**
     * @return the list of the registered
     * tenants in the service
     */

    public ArrayList<String> getRegistered(){
        return potentialTenants;
    }
    public String getLastInsertedUnit(){
        int x=potentialTenants.size();

        return potentialTenants.get(x-1);
    }
}
