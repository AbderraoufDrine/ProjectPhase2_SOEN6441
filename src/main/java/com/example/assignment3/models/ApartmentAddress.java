package com.example.assignment3.models;

/**
 * This is the model of the Apartment that is used
 * in the implementation of the AddressFactory
 * this class also uses the builder pattern in the function build Address
 */

public class ApartmentAddress extends Address{
    private int unitNumber;

    /**
     * Default constructor
     */
    public ApartmentAddress() {
    }

    /**
     *  Constructor
     */
    public ApartmentAddress(int streetNumber, String streetName, String city, String province, String postalCode, int unitNumber) {
        super(streetNumber, streetName, city, province, postalCode);
        this.unitNumber = unitNumber;
    }

    /**
     * identify a value for the extra part
     * of the apartment address
     */
    @Override
    public void BuildAddress(int streetNumber, String streetName, String city,
                             String province,String postalCode,int unitNumber) {
        super.BuildAddress(streetNumber,streetName, city,
                 province,postalCode,unitNumber);
//        System.out.println("Please enter the unitNumber");
        setUnitNumber(unitNumber);

    }

    /**
     * set the unit number of the apartment
     */
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    /**
     * @return the number of the apartment
     */
    public int getUnitNumber() {
        return unitNumber;
    }

    /**
     * @return the information of an apartment address
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "{" +
                "unitNumber=" + unitNumber +
                '}';
    }
}
