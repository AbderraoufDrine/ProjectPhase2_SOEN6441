package com.example.assignment3.controllers;

import com.example.assignment3.Database.TenantRepository;
import com.example.assignment3.models.Tenant;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TenantControllerTest extends TestCase {
    TenantRepository tenantRepository = new TenantRepository();
    TenantController controller = new TenantController(tenantRepository);
    String name = "abc";
    String email = "abc@xyz.com";

    @Test
    void testCreateTenant() {
        Tenant obj = new Tenant();
        obj.setName("abc");
        obj.setEmail("abc@xyz.com");
        controller.createTenant(name, email);
        Tenant tenant = tenantRepository.get(email);
        //assert
        if ((tenant.getEmail()).equals(obj.getEmail()) && (tenant.getName()).equals(obj.getName())) {
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    void testGetTenant() {
        controller.createTenant(name, email);
        Tenant tenant = tenantRepository.get(email);

        Tenant obj = controller.getTenant(email);
        if ((tenant.getEmail()).equals(obj.getEmail()) && (tenant.getName()).equals(obj.getName())) {
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    void testAllTenants() {
        controller.createTenant(name, email);
        Tenant tenant = tenantRepository.get(email);

        controller.createTenant("wer", "wer@sdf.com");
        Tenant tenant2 = tenantRepository.get(email);

        controller.createTenant("kju", "kju@qsd.com");
        Tenant tenant3 = tenantRepository.get(email);

        ArrayList<Tenant> art = controller.allTenants();

        if (art.contains(tenant) && art.contains(tenant2) && art.contains(tenant3)) {
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    void testRemoveTenant() {
        controller.createTenant(name, email);
        Tenant obj = controller.getTenant(email);
        System.out.println(obj.getName());
        System.out.println(obj.getEmail());
        assertEquals(controller.removeTenant(obj.getEmail()), "Tenant has been deleted");
    }

    @Test
    void testDisplayTenants() {
        controller.createTenant(name, email);
        Tenant tenant = tenantRepository.get(email);

        controller.createTenant("wer", "wer@sdf.com");
        Tenant tenant2 = tenantRepository.get(email);

        controller.createTenant("kju", "kju@qsd.com");
        Tenant tenant3 = tenantRepository.get(email);

        ArrayList<Tenant> art = controller.displayTenants();

        if (art.contains(tenant) && art.contains(tenant2) && art.contains(tenant3)) {
            assert (true);
        } else {
            assert (false);
        }
    }
}