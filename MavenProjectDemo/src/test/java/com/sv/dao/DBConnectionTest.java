package com.sv.dao;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.sv.model.Employee;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {

    @Test
    void testAddEmployee() throws SQLException {
        EmployeeDao dao = new EmployeeDao();

        Date hire_date = Date.valueOf("2000-05-12");
        Double salary = 58200.0;
        int employee_id = 207;
        Integer manager_id = 200;
        Integer department_id = 10;
        String first_name = "Aditya";
        String last_Name = "Sharma";
        String email = "adi@gmail.com";
        String phoneNumber = "9876543210";
        String job_title = "Manager";

        Employee emp = new Employee(employee_id, first_name, last_Name,email,phoneNumber,  hire_date , job_title
              , salary,  manager_id, department_id);
               
 

        Employee savedEmp = dao.addEmployee(emp);

        assertNotNull(savedEmp);
        assertEquals("Aditya", savedEmp.getFirstName());
    }

    @Test
    void testPrintAllEmployees() {
        EmployeeDao dao = new EmployeeDao();
        assertDoesNotThrow(() -> dao.printAllEmployees());
    }

    @Test
    void testGetConnection() throws SQLException {
        Connection connection = DBConnection.getConnection();
        assertNotNull(connection);
        connection.close();
    }
}