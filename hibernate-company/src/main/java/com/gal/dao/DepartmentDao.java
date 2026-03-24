package com.gal.dao;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DepartmentDao {

    public Department addDepartment(Department department) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(department);
            tx.commit();
            return department;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Department getDepartment(int id) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        Department department = em.find(Department.class, id);
        em.close();

        return department;
    }

    public void deleteDepartment(int id) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Department department = em.find(Department.class, id);
            if (department != null) {
                em.remove(department);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}