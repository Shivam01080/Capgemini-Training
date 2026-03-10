package com.gal.dao;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Parking;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParkingDaoTest {

    private static ParkingDao dao;

    @BeforeAll
    static void setup() {
        dao = new ParkingDao();
    }

    @AfterAll
    static void tearDown() {
        EntityManagerFactoryProvider.close();
    }

    @Test
    @Order(1)
    void testAddParking() {

        Parking parking = new Parking();
        parking.setFloorNo(2);
        parking.setSlotNumber("A001");

        Parking saved = dao.addParking(parking);

        assertNotNull(saved.getParkingId());
        System.out.println("Inserted Parking ID: " + saved.getParkingId());
    }

    @Test
    @Order(2)
    void testGetParking() {

        Parking parking = dao.getParking(1);

        assertNotNull(parking);
        assertEquals("A001", parking.getSlotNumber());
    }

    @Test
    @Order(3)
    void testDeleteParking() {

        dao.deleteParking(1);

        Parking deleted = dao.getParking(1);
        assertNull(deleted);
    }
}