package com.gal;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Employee;
import com.gal.model.Project;

import jakarta.persistence.EntityManager;
import java.sql.Date;

public class EntityManagerFactoryConnection {

    public static void main(String[] args) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();

        try {
            em.getTransaction().begin();
            Employee manager = em.find(Employee.class, 100);

            if (manager == null) {
                System.out.println("Manager with ID 100 not found!");
                em.getTransaction().rollback();
                return;
            }

            // 5 projects
            Project p1 = new Project(
                    "Banking App",
                    "HDFC",
                    Date.valueOf("2024-01-01"),
                    Date.valueOf("2024-12-31"),
                    500000.0,
                    manager
            );

            Project p2 = new Project(
                    "E-Commerce Platform",
                    "Amazon",
                    Date.valueOf("2024-02-01"),
                    Date.valueOf("2024-11-30"),
                    750000.0,
                    manager
            );

            Project p3 = new Project(
                    "Insurance Portal",
                    "LIC",
                    Date.valueOf("2024-03-01"),
                    Date.valueOf("2024-10-30"),
                    400000.0,
                    manager
            );

            Project p4 = new Project(
                    "HR Management System",
                    "TCS",
                    Date.valueOf("2024-04-01"),
                    Date.valueOf("2024-09-30"),
                    300000.0,
                    manager
            );

            Project p5 = new Project(
                    "Inventory System",
                    "Reliance",
                    Date.valueOf("2024-05-01"),
                    Date.valueOf("2024-08-30"),
                    350000.0,
                    manager
            );
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.persist(p5);

            em.getTransaction().commit();

            System.out.println("5 Projects inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            EntityManagerFactoryProvider.close();
        }
    }
}