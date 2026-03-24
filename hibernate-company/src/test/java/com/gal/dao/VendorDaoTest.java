package com.gal.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Vendor;

class VendorDaoTest {

    private static VendorDao dao = new VendorDao();

    @AfterAll
    static void closeConnections() {
        EntityManagerFactoryProvider.close();
    }

    @Test
    void testAddVendor() {

        Vendor vendor = new Vendor("Rahul Kumar");

        Vendor actual = dao.addVendor(vendor);

        System.out.println(actual);

        assertNotNull(actual);
        assertTrue(actual.getVendorId() > 0);  // Important check
    }
}