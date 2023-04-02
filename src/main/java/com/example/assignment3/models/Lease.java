package com.example.assignment3.models;

import java.util.Date;

/**
 * This is the model of the Lease
 */

public class Lease {

    static int serializer = 1000;
    private int Id;
    private Tenant tenant;
    private RentalUnit rentalUnit;
    private Date startDate;
    private Date endDate;
    private double price;

    /**
     * Default constructor
     */
    public Lease(){
        setId(serializer);
        serializer++;
    }

    /**
     *  Constructor
     */
    public Lease(Tenant tenant, RentalUnit rentalUnit, Date startDate, Date endDate, double price) {
        this.tenant = tenant;
        this.rentalUnit = rentalUnit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }


    /**
     * set the ID of the lease
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * set the Tenant that wants to rent
     */
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    /**
     * set the rental unit that the tenant wants to rent
     */
    public void setRentalUnit(RentalUnit rentalUnit) {
        this.rentalUnit = rentalUnit;
    }

    /**
     * set the start date of the lease
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * set the end date of the lease
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * set the price of the rental unit in the lease
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the ID of the lease
     */
    public int getId() {
        return Id;
    }

    /**
     * @return the tenant who rented the property in the lease
     */
    public Tenant getTenant() {
        return tenant;
    }

    /**
     * @return the rented unit in the lease
     */
    public RentalUnit getRentalUnit() {
        return rentalUnit;
    }

    /**
     * @return the start date of the lease
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return the end date of the lease
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @return the price of the rental unit in the lease
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the information of the lease
     */
    @Override
    public String toString() {
        return "Lease{" +
                "Id=" + Id +
                ", tenant=" + tenant +
                ", rentalUnit=" + rentalUnit +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                '}';
    }
}
