package com.gal.dao;

import com.gal.model.Employee;
import com.gal.hibernate_company.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManager;

public class EmployeeDao {

    public Employee getEmployee(int id) {

        EntityManager em =
                EntityManagerFactoryProvider.getEntityManager();

        Employee employee = em.find(Employee.class, id);

        em.close();

        return employee;
    }
}