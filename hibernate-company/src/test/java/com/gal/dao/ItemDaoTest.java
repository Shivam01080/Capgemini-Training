package com.gal.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Item;

import jakarta.persistence.EntityManager;

class ItemDaoTest {

    private static ItemDao dao = new ItemDao();

    @AfterAll
    static void closeConnections() {
        EntityManagerFactoryProvider.close();
    }

    @Test
    void testAddItem() {

        Item item = new Item("Electronics",
                             "Laptop",
                             55000);

        Item actual = dao.addItem(item);

        System.out.println(actual);

        assertNotNull(actual);
        assertTrue(actual.getItemId() > 0);
    }
}