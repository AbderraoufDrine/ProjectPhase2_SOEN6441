package com.example.assignment3.models;

import java.util.Scanner;

/**
 * This is the model of an Address
 */


public abstract class Address {
    private int streetNumber;
    private String streetName;
    private String city;
    private String province;
    private String postalCode;

    Scanner input = new Scanner(System.in);

    /**
     * Default constructor
     */
    public Address() {
    }

    /**
     * Constructor
     */
    public Address(int streetNumber, String streetName, String city, String province, String postalCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }


    /**
     * set the street number of the address
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * set the street name of the address
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * set the city name of the address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * set the province of city in the address
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * set the postal code of the address
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the street number in the address
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * @return the street name in the address
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @return the city name in the address
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the province name in the address
     */
    public String getProvince() {
        return province;
    }

    /**
     * @return the postal code in the address
     */
    public String getPostalCode() {
        return postalCode;
    }


    /**
     * Build the address information
     * for use
     */
    public void BuildAddress(int streetNumber, String streetName, String city,
                             String province,String postalCode,int unitNumber){
//        System.out.println("Please enter the city name");
        setCity(city);
//        System.out.println("Please enter the street name");
        setStreetName(streetName);
//        System.out.println("Please enter the street number");
        setStreetNumber(streetNumber);
//        System.out.println("Please enter the province");
        setProvince(province);
//        System.out.println("Please enter the postal code");
        setPostalCode(postalCode);


    }

    /**
     * @return the information of the address
     */
    @Override
    public String toString() {
        return "Address{" +
                "streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
