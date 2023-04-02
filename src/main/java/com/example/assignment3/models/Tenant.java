package com.example.assignment3.models;

/**
 * This class is the model for Tenant
 *
 */
public class Tenant {
    private String name;
    private String email;

    /**
     * Tenant Default Constructor
     */
    public Tenant() {
    }

    /**
     * Tenant Constructor
     */
    public Tenant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * set the name of the tenant
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the email of the tenant
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return  the name of the tenant
     */
    public String getName() {
        return name;
    }

    /**
     * @return  the email of the tenant
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return  the tenant information
     */
    @Override
    public String toString() {
        return "Tenant{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
