package com.gal.dao;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Department;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentDaoTest {

    private static DepartmentDao dao;

    @BeforeAll
    static void setup() {
        dao = new DepartmentDao();
    }

    @AfterAll
    static void tearDown() {
        EntityManagerFactoryProvider.close();
    }
    @Test
    @Order(1)
    void testGetDepartment() {

        Department dept = dao.getDepartment(1);

        if (dept != null) {
            System.out.println("Department Found: " + dept.getDepartmentName());
            assertNotNull(dept);
        } else {
            System.out.println("Department not found");
            assertNull(dept);
        }
    }

    @Test
    @Order(2)
    void testDeleteDepartment() {

        Department dept = dao.getDepartment(1);

        if (dept != null) {
            dao.deleteDepartment(1);
            Department deleted = dao.getDepartment(1);
            assertNull(deleted);
            System.out.println("Department deleted successfully");
        } else {
            System.out.println("No department to delete");
        }
    }
}