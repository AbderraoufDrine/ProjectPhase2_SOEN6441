package com.example.assignment3.models;

/**
 * This is the model of a rental unit
 */

public abstract class RentalUnit {

    static int serializer = 1;
    private int Id;
    private int bedrooms;
    private int bathrooms;
    private int area;
    private Address address;
    private boolean isRented;


    /**
     * Default constructor
     */
    public RentalUnit() {
        this.setId(serializer);
        serializer++;

    }

    /**
     * Constructor
     */
    public RentalUnit(int bedrooms, int bathrooms, int area, Address address, boolean isRented) {
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.area = area;
        this.address = address;
        this.isRented = isRented;
    }

    /**
     * set the ID of the unit
     */
    public void setId(int id) {
        this.Id = id;
    }

    /**
     * set the number of bedrooms of the unit
     */
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    /**
     * set the number of bathrooms of the unit
     */
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    /**
     * set the area of the unit
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * set the address of the unit
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * set the type of the unit if it is vacant or not
     */
    public void setRented(boolean rented) {
        isRented = rented;
    }

    /**
     * @return the ID of the unit
     */
    public int getId() {
        return Id;
    }

    /**
     * @return the number of bedrooms of the unit
     */
    public int getBedrooms() {
        return bedrooms;
    }

    /**
     * @return the number of bathrooms of the unit
     */
    public int getBathrooms() {
        return bathrooms;
    }

    /**
     * @return the area of the unit
     */
    public int getArea() {
        return area;
    }

    /**
     * @return the address of the unit
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @return the type of the unit
     */
    public boolean isRented() {
        return isRented;
    }

    /**
     * @return the unit information
     */
    @Override
    public String toString() {
        return "RentalUnit{" +
                "Id='" + this.Id + '\'' +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", area=" + area +
                ", address=" + address +
                ", isRented=" + isRented +
                '}';
    }
}
