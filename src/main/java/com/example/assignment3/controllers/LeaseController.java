package com.example.assignment3.controllers;

import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.models.Lease;
import com.example.assignment3.models.Tenant;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This is the lease controller
 * which performs every operation
 * regarding the leases
 */
public class LeaseController {
    TenantRepository tenantRepository;
    RentalUnitRepository rentalUnitRepository;
    LeaseRepository leaseRepository;

    /**
     * Constructor
     */
    public LeaseController(TenantRepository tenantRepository, RentalUnitRepository rentalUnitRepository, LeaseRepository leaseRepository){
        this.leaseRepository = leaseRepository;
        this.tenantRepository = tenantRepository;
        this.rentalUnitRepository = rentalUnitRepository;
    }

    /**
     * create a lease and
     * store it in the database
     */
    public void rentUnit(String email, int Id, String startDate, String endDate, double rent) throws ParseException {
        Lease obj = new Lease();
        try {
            obj.setTenant(tenantRepository.get(email));
            obj.setRentalUnit(rentalUnitRepository.get(Id));
            String dateFormat = "dd/mm/yyyy";
            obj.setStartDate(new SimpleDateFormat(dateFormat).parse(startDate));
            obj.setEndDate(new SimpleDateFormat(dateFormat).parse(endDate));
            obj.setPrice(rent);
            rentalUnitRepository.update(obj.getRentalUnit().getId(),true);
            leaseRepository.save(obj);
            System.out.println("Lease has been created");
            System.out.println(obj);
        }
        catch (Exception e){
            System.out.println("It seems there was an error in renting the unit");
        }
    }

    /**
     * display all the leases in the database
     */
    public void displayLeases(){
        try {
            for (Lease l : leaseRepository.getAll())
                System.out.println(l);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

    /**
     * display all the tenants in the database
     * These tenants have a lease and rented property
     */
    public void displayTenantsInLeases(){
        try {
            for (Tenant t : leaseRepository.getAllTenants())
                System.out.println(t);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

}
