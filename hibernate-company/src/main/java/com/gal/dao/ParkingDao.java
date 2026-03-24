package com.gal.dao;

import com.gal.hibernate_company.EntityManagerFactoryProvider;
import com.gal.model.Parking;
import jakarta.persistence.EntityManager;

public class ParkingDao {

    public Parking addParking(Parking parking) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        em.getTransaction().begin();

        em.persist(parking);

        em.getTransaction().commit();
        em.close();

        return parking;
    }

    public Parking getParking(int id) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        Parking parking = em.find(Parking.class, id);
        em.close();

        return parking;
    }

    public void deleteParking(int id) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        em.getTransaction().begin();

        Parking parking = em.find(Parking.class, id);

        if (parking != null) {
            em.remove(parking);
        }

        em.getTransaction().commit();
        em.close();
    }
}