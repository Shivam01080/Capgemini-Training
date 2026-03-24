package com.gal.dao;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Employee;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {

    static EmployeeDao dao;

    @BeforeAll
    static void setup() {
        dao = new EmployeeDao();
    }

    @Test
    void testGetEmployee() {
        Employee employee = dao.getEmployee(100);

        assertNotNull(employee);
        assertEquals("Steven", employee.getFirst_name());
    }

    @AfterAll
    static void cleanup() {
        EntityManagerFactoryProvider
                .getEntityManager()
                .close();
    }
}