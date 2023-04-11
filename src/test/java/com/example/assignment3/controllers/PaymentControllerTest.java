package com.example.assignment3.controllers;

import com.example.assignment3.Database.LeaseRepository;
import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.models.Lease;
import com.example.assignment3.models.Tenant;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentControllerTest extends TestCase {
    LeaseRepository leaseRepository = new LeaseRepository();
    TenantRepository tenantRepository = new TenantRepository();
    PaymentController controller = new PaymentController(leaseRepository);
    TenantController tc = new TenantController(tenantRepository);

    @Test
    void testPayRent() {
        String email = "jut@ert.com";
        String name = "abc";
        tc.createTenant(name, email);

        Lease obj = new Lease();
        obj.setTenant(tenantRepository.get(email));

        leaseRepository.save(obj);
        Tenant tenant = tenantRepository.get(email);

        String message = controller.payRent(name);
        if (message.equals(tenant.getName() + " " + "has paid the rent")) {
            assert (true);
        } else if (message.equals("The rent is not paid")) {
            assert false;
        }
    }

    @Test
    void testDisplayAllPaidTenants() {
        controller.displayAllPaidTenants();
        assert (true);
    }
}