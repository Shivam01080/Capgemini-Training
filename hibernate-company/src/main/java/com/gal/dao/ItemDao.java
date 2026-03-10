package com.gal.dao;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ItemDao {

    public Item addItem(Item item) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(item);
            tx.commit();
            return item;

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();   // VERY IMPORTANT
        }
    }
}