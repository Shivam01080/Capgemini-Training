package com.mess;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryConnection {

	private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("mess_db_pu");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
  }
