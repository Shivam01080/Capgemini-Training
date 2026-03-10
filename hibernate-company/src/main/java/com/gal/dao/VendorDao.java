package com.gal.dao;

import com.gal.model.Vendor;
import com.gal.hibernate_company.EntityManagerFactoryProvider;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VendorDao {

    public Vendor addVendor(Vendor vendor) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(vendor);
            tx.commit();
            return vendor;

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;

        } finally {
            em.close();   // Always close
        }
    }
}