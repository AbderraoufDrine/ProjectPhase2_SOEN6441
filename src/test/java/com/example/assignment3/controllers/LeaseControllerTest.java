package com.example.assignment3.controllers;

import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.RentalUnitRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.models.Lease;
import com.example.assignment3.models.Tenant;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeaseControllerTest extends TestCase {
    TenantRepository tenantRepository = new TenantRepository();
    RentalUnitRepository rentalUnitRepository = new RentalUnitRepository();
    LeaseRepository leaseRepository = new LeaseRepository();
    RentalUnitController rController = new RentalUnitController(rentalUnitRepository, tenantRepository);
    LeaseController controller = new LeaseController(tenantRepository, rentalUnitRepository, leaseRepository);
    TenantController tc = new TenantController(tenantRepository);
    String email = "abc@xyz.com";
    String startDate = "21-02-2004";
    String endDate = "21-02-2014";
    double rent = 500.0;

    @Test
    void testRentUnit() throws ParseException {
        Lease obj = new Lease();
        obj.setTenant(tenantRepository.get(email));
        rController.createRentalUnit("apartment", 2, 1, 200, 340, "Milton Avenue", "Montreal", "Quebec", "S2V3E4", 1769);
        obj.setRentalUnit(rentalUnitRepository.getLastInsertedUnit());
        String dateFormat = "dd-mm-yyyy";
        obj.setStartDate(new SimpleDateFormat(dateFormat).parse(startDate));
        obj.setEndDate(new SimpleDateFormat(dateFormat).parse(endDate));
        obj.setPrice(rent);
        tc.createTenant("abc", "jut@ert.com");
        obj.setTenant(tenantRepository.getLastInsertedUnit());
        rentalUnitRepository.update(obj.getRentalUnit().getId(), true);

        controller.rentUnit(email, rentalUnitRepository.getLastInsertedUnit().getId(), startDate, endDate, rent);
        Lease newLease = leaseRepository.getLastInsertedUnit();
        tc.createTenant("abc", "jut@ert.com");
        newLease.setTenant(tenantRepository.getLastInsertedUnit());

        if (newLease.getTenant().getName().equals(obj.getTenant().getName()) && newLease.getTenant().getEmail().equals(obj.getTenant().getEmail()) && newLease.getRentalUnit().equals(obj.getRentalUnit()) && newLease.getPrice() == obj.getPrice() && newLease.getEndDate().equals(obj.getEndDate()) && newLease.getStartDate().equals(obj.getStartDate())) {
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    void testDisplayLeases() throws ParseException {
        rController.createRentalUnit("apartment", 2, 1, 200, 340, "Milton Avenue", "Montreal", "Quebec", "S2V3E4", 1769);
        controller.rentUnit(email, rentalUnitRepository.getLastInsertedUnit().getId(), startDate, endDate, rent);
        Lease newLease = leaseRepository.getLastInsertedUnit();

        rController.createRentalUnit("apartment", 2, 1, 200, 340, "Milton Avenue", "Montreal", "Quebec", "S2V3E4", 1769);
        controller.rentUnit("sdf@tyu.com", rentalUnitRepository.getLastInsertedUnit().getId(), "21-10-2014", "10-12-2028", 200);
        Lease newLease2 = leaseRepository.getLastInsertedUnit();

        rController.createRentalUnit("apartment", 2, 1, 200, 340, "Milton Avenue", "Montreal", "Quebec", "S2V3E4", 1769);
        controller.rentUnit("new@tjk.com", rentalUnitRepository.getLastInsertedUnit().getId(), "13-07-2020", "05-09-2024", 300);
        Lease newLease3 = leaseRepository.getLastInsertedUnit();

        ArrayList<Lease> art = controller.displayLeases();

        if (art.contains(newLease) && art.contains(newLease2) && art.contains(newLease2)) {
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    void displayTenantsInLeases() throws ParseException {
        rController.createRentalUnit("apartment", 2, 1, 200, 340, "Milton Avenue", "Montreal", "Quebec", "S2V3E4", 1769);
        controller.rentUnit(email, rentalUnitRepository.getLastInsertedUnit().getId(), startDate, endDate, rent);
        Lease newLease = leaseRepository.getLastInsertedUnit();
        tc.createTenant("abc", "jut@ert.com");
        newLease.setTenant(tenantRepository.getLastInsertedUnit());

        rController.createRentalUnit("apartment", 2, 1, 200, 340, "Milton Avenue", "Montreal", "Quebec", "S2V3E4", 1769);
        controller.rentUnit("sdf@tyu.com", rentalUnitRepository.getLastInsertedUnit().getId(), "21-10-2014", "10-12-2028", 200);
        Lease newLease2 = leaseRepository.getLastInsertedUnit();
        tc.createTenant("dgg", "hfh@dgdfg.com");
        newLease.setTenant(tenantRepository.getLastInsertedUnit());

        rController.createRentalUnit("apartment", 2, 1, 200, 340, "Milton Avenue", "Montreal", "Quebec", "S2V3E4", 1769);
        controller.rentUnit("new@tjk.com", rentalUnitRepository.getLastInsertedUnit().getId(), "13-07-2020", "05-09-2024", 300);
        Lease newLease3 = leaseRepository.getLastInsertedUnit();
        tc.createTenant("rjr", "dd@rtg.com");
        newLease.setTenant(tenantRepository.getLastInsertedUnit());

        controller.displayTenantsInLeases();
        assert (true);
    }
}