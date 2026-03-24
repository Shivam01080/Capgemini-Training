package com.gal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gal.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Repository
public class DepartmentDaoImp implements DepartmentDao {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public Department find(int depid) {

        EntityManager em = emf.createEntityManager();
        return em.find(Department.class, depid);
    }

    @Override
    public List<Department> findAll() {

        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Department", Department.class)
                 .getResultList();
    }

    @Override
    @Transactional
    public  Department add(Department department) {

        EntityManager em = emf.createEntityManager();
        em.persist(department);
		return department;
    }

    @Override
    @Transactional
    public void delete(int depid) {

        EntityManager em = emf.createEntityManager();
        Department dep = em.find(Department.class, depid);
        em.remove(dep);
    }

    @Override
    @Transactional
    public void update(Department department) {

        EntityManager em = emf.createEntityManager();
        em.merge(department);
    }
}