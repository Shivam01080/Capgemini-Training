package com.gal.service;

import java.sql.Date;
import java.util.List;
import com.gal.model.Employee;

public interface EmployeeService {

    Employee find(int empId);

    List<Employee> findAll();

    Employee add(Employee employee);

    void delete(int empId);

   Employee update(Employee employee);

    Employee findByFirstname(String firstname);

    Employee findByLastname(String lastname);
    
    List<Employee> findByCabnoAndBookingDate(String cabno, Date bookingDate);
    }
