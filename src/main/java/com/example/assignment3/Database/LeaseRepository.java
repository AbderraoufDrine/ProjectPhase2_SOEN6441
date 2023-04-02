package com.example.assignment3.Database;

import com.example.assignment3.models.Lease;
import com.example.assignment3.models.Tenant;

import java.util.ArrayList;

/**
 * This is the mocked database of the tenants
 * in the system
 */

public class LeaseRepository {
    private ArrayList<Lease> leaseArrayList = new ArrayList<>();

    /**
     * @return the if a lease has been
     * saved in the database
     */
    public boolean save(Lease obj){
        return leaseArrayList.add(obj);
    }

    /**
     * @return the if a lease has been
     * deleted from the database
     */
    public boolean delete(Lease obj){
        return leaseArrayList.remove(obj);
    }
    public Lease get(int Id) {
        Lease obj = null;
        for (Lease l : leaseArrayList)
            if (l.getId() == Id)
                obj =  l;
        return obj;
    }

    /**
     * @return all the leases stored
     * in the database
     */
    public ArrayList<Lease> getAll(){
        return leaseArrayList;
    }

    /**
     * @return all the tenants who
     * have leases stored in the database
     */
    public ArrayList<Tenant> getAllTenants(){
        ArrayList<Tenant> filteredList = new ArrayList<>();
        for(Lease l: leaseArrayList)
            filteredList.add(l.getTenant());
        return filteredList;
    }

    /**
     * @return a single tenants who is renting
     * a unit and has a lease in the database
     */
    public Tenant getSingleTenant(String name){
        Tenant obj = null;
        for(Lease l: leaseArrayList)
            if(l.getTenant().getName().equals(name))
                obj = l.getTenant();
        return obj;
    }

}
