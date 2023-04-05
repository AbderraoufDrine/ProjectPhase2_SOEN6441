package com.example.assignment3.controllers;

import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.models.Tenant;

import java.util.ArrayList;

/**
 * This is the tenant controller
 * which performs every operation
 * regarding the tenants
 */

public class TenantController {

    TenantRepository tenantRepository;

    /**
     * Constructor
     */
    public TenantController(TenantRepository obj){
        tenantRepository = obj;
    }

    /**
     * create a tenant and
     * store it in the database
     */
    public void createTenant(String name, String email){
        Tenant obj = new Tenant();
        try {
            obj.setName(name);
            obj.setEmail(email);
            tenantRepository.save(obj);
            System.out.println("Tenant has been created");
            System.out.println(obj);
        }
        catch (Exception e){
            System.out.println("It seems something is wrong");
        }
    }

    /**
     * @return  a tenant
     * from the database by
     * searching his name
     */
    public Tenant getTenant(String email){
        return tenantRepository.get(email);
    }

    /**
     * @return all the tenants in
     * the database
     */
    public ArrayList<Tenant> allTenants(){
        return tenantRepository.getAll();
    }

    /**
     * @return a string indicating if
     * a tenant has been deleted or not
     */
    public String removeTenant(String email){
        try {
            Tenant obj = getTenant(email);
            if (tenantRepository.delete(obj))
                return ("Tenant has been deleted");
            else
                return ("It seems there is no tenant with this name");
        }
        catch (Exception e){
            System.out.println("It seems something is wrong");
        }
        return "";
    }

    /**
     * display all the tenants in the database
     * These tenants may not have a lease
     */
    public ArrayList<Tenant> displayTenants(){
        return allTenants();
//        try {
//            for (Tenant t : allTenants())
//                System.out.println(t);
//        }
//        catch (Exception e){
//            System.out.println("It seems something is wrong with this operation");
//        }
    }
}
