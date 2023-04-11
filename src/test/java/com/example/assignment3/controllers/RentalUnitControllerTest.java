package com.example.assignment3.controllers;

import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.models.*;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RentalUnitControllerTest extends TestCase {
    private RentalUnitFactory factory=new RentalUnitFactory();
    private AddressFactory adFactory=new AddressFactory();

    Observer observer=new Observer();

    RentalUnitRepository repository=new RentalUnitRepository();

    TenantRepository tenantRepository=new TenantRepository();
    RentalUnitController controller=new RentalUnitController(repository,tenantRepository);
    String type="apartment";
    int numOfBed=2;
    int numOfBath=1;
    int area=220;
    int streetNumber=1650;
    String streetName="Bloomfield Avenue";
    String city="Montreal";
    String province="Quebec";
    String postalCode="Q3P1W3";
    int unitNumber=1209;

    String name="abc";
    String email="abc@xyz.com";
    TenantController tcontroller= new TenantController(tenantRepository);
    @Test
    void testCreateRentalUnit() {
        RentalUnit obj = null;
        obj = factory.getInstance(type);
        obj.setAddress(adFactory.getInstance(type));
        obj.getAddress().BuildAddress(streetNumber,streetName,city,province,postalCode,unitNumber);
        obj.setBedrooms(numOfBed);
        obj.setBathrooms(numOfBath);
        obj.setArea(area);
        obj.setRented(false);

        controller.createRentalUnit(type,numOfBed, numOfBath, area,streetNumber, streetName, city, province, postalCode,unitNumber);

        if(repository.getLastInsertedUnit().isRented()==obj.isRented() && repository.getLastInsertedUnit().getAddress().getStreetNumber()==obj.getAddress().getStreetNumber() && repository.getLastInsertedUnit().getAddress().getStreetName().equals(obj.getAddress().getStreetName()) && repository.getLastInsertedUnit().getAddress().getPostalCode().equals(obj.getAddress().getPostalCode()) && repository.getLastInsertedUnit().getAddress().getProvince().equals(obj.getAddress().getProvince()) && repository.getLastInsertedUnit().getAddress().getCity().equals(obj.getAddress().getCity()) && repository.getLastInsertedUnit().getBedrooms()==obj.getBedrooms() && repository.getLastInsertedUnit().getBathrooms()==obj.getBathrooms() && repository.getLastInsertedUnit().getArea()==obj.getArea()){
            assert(true);
        }else{
            assert(false);
        }
    }

    @Test
    void testGetRentalUnit() {
        controller.createRentalUnit(type,numOfBed, numOfBath, area,streetNumber, streetName, city, province, postalCode,unitNumber);
        RentalUnit obj =repository.getLastInsertedUnit();
        RentalUnit newr=controller.getRentalUnit(obj.getId());

        if(newr.isRented()==obj.isRented() && newr.getAddress().getStreetNumber()==obj.getAddress().getStreetNumber() && newr.getAddress().getStreetName().equals(obj.getAddress().getStreetName()) && newr.getAddress().getPostalCode().equals(obj.getAddress().getPostalCode()) && newr.getAddress().getProvince().equals(obj.getAddress().getProvince()) && newr.getAddress().getCity().equals(obj.getAddress().getCity()) && newr.getBedrooms()==obj.getBedrooms() && newr.getBathrooms()==obj.getBathrooms() && newr.getArea()==obj.getArea()){
            assert(true);
        }else{
            assert(false);
        }
    }

    @Test
    void testRemoveRentalUnit() {
        controller.createRentalUnit(type,numOfBed, numOfBath, area,streetNumber, streetName, city, province, postalCode,unitNumber);
        int id=repository.getLastInsertedUnit().getId();
        assertEquals(controller.removeRentalUnit(id), "The unit has been deleted");
    }

    @Test
    void testChangeRented() {
        controller.createRentalUnit(type,numOfBed, numOfBath, area,streetNumber, streetName, city, province, postalCode,unitNumber);
        int id=repository.getLastInsertedUnit().getId();
        assertEquals(controller.changeRented(id,"rent"), "The type of RentalUnit is changed");
    }

    @Test
    void testDisplayAllUnits() {
        controller.createRentalUnit(type, numOfBed, numOfBath, area, streetNumber, streetName, city, province, postalCode, unitNumber);
        RentalUnit obj = repository.getLastInsertedUnit();

        controller.createRentalUnit("house", 7, 5, 700, 890, "Herrald Avenue", "Winnipeg", "Ontario", "K9UO0P", 6700);
        RentalUnit obj2 = repository.getLastInsertedUnit();

        controller.createRentalUnit("house", 4, 2, 500, 500, "Lexus Avenue", "Toronto", "Ontario", "K9UT6R", 1200);
        RentalUnit obj3 = repository.getLastInsertedUnit();

        ArrayList<RentalUnit> art = controller.displayAllUnits();

        if (art.contains(obj) && art.contains(obj2) && art.contains(obj3)) {
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    void testDisplayRentedUnits() {
        controller.createRentalUnit(type, numOfBed, numOfBath, area, streetNumber, streetName, city, province, postalCode, unitNumber);
        RentalUnit obj = repository.getLastInsertedUnit();
        obj.setRented(true);
        repository.save(obj);

        controller.createRentalUnit("house", 7, 5, 700, 890, "Herrald Avenue", "Winnipeg", "Ontario", "K9UO0P", 6700);
        RentalUnit obj2 = repository.getLastInsertedUnit();
        obj2.setRented(true);
        repository.save(obj2);

        controller.createRentalUnit("house", 4, 2, 500, 500, "Lexus Avenue", "Toronto", "Ontario", "K9UT6R", 1200);
        RentalUnit obj3 = repository.getLastInsertedUnit();
        obj3.setRented(true);
        repository.save(obj3);

        ArrayList<RentalUnit> art = controller.displayRentedUnits();

        if (art.contains(obj) && art.contains(obj2) && art.contains(obj3)) {
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    void testVacantUnits() {
        controller.createRentalUnit(type,numOfBed, numOfBath, area,streetNumber, streetName, city, province, postalCode,unitNumber);
        RentalUnit obj =repository.getLastInsertedUnit();

        controller.createRentalUnit("house",7, 5, 700,890, "Herrald Avenue", "Winnipeg", "Ontario", "K9UO0P",6700);
        RentalUnit obj2 =repository.getLastInsertedUnit();

        controller.createRentalUnit("house",4, 2, 500,500, "Lexus Avenue", "Toronto", "Ontario", "K9UT6R",1200);
        RentalUnit obj3 =repository.getLastInsertedUnit();

        ArrayList<RentalUnit> art=controller.vacantUnits();

        if (art.contains(obj) && art.contains(obj2) && art.contains(obj3)) {
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    void testRegisterTenant() {

        controller.createRentalUnit(type,numOfBed, numOfBath, area,streetNumber, streetName, city, province, postalCode,unitNumber);
        RentalUnit obj =repository.getLastInsertedUnit();
        obj.setRented(true);

        tcontroller.createTenant(name,email);
        Tenant tenant = tenantRepository.get(email);
        Observer os=controller.ReturnObserver();

        controller.RegisterTenant(obj.getId(),tenant.getEmail());
        String[] as=os.getLastInsertedUnit().split(" ");
        if(obj.getId()==Integer.parseInt(as[1]) && tenant.getEmail().equals(as[0])){
            assert(true);
        }else{
            assert(false);
        }
    }
}