package com.mess.hibernate_mess;

import com.gal.model.Supplier;
import com.gal.model.Item;
import com.gal.model.Supply;
import com.mess.EntityManagerFactoryConnection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class MainApp {

public static void main(String[] args) {

    EntityManager em = EntityManagerFactoryConnection.getEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    Supplier s1 = new Supplier();
    s1.setSname("Rajan enterprises");
    s1.setSrank(4.5);
    s1.setCity("Delhi");

    Supplier s2 = new Supplier();
    s2.setSname("Indian supply");
    s2.setSrank(3.4);
    s2.setCity("Gurugram");

    em.persist(s1);
    em.persist(s2);

    Item i1 = new Item();
    i1.setName("Tomato");
    i1.setType("Veg");

    Item i2 = new Item();
    i2.setName("Onion");
    i2.setType("Veg");

    Item i3 = new Item();
    i3.setName("Sugar");
    i3.setType("Groc");

    em.persist(i1);
    em.persist(i2);
    em.persist(i3);

    Supply sp1 = new Supply();
    sp1.setSupplier(s1);
    sp1.setItem(i2);
    sp1.setDatesupply(java.sql.Date.valueOf("2019-03-03"));
    sp1.setPrice(36);
    sp1.setQty(50);

    Supply sp2 = new Supply();
    sp2.setSupplier(s1);
    sp2.setItem(i3);
    sp2.setDatesupply(java.sql.Date.valueOf("2019-05-05"));
    sp2.setPrice(10);
    sp2.setQty(45);

    Supply sp3 = new Supply();
    sp3.setSupplier(s2);
    sp3.setItem(i1);
    sp3.setDatesupply(java.sql.Date.valueOf("2019-08-15"));
    sp3.setPrice(50);
    sp3.setQty(10);

    em.persist(sp1);
    em.persist(sp2);
    em.persist(sp3);

    tx.commit();

    System.out.println("\nAll Supplier Names:");
    List<String> suppliers = em.createQuery("select s.sname from Supplier s", String.class).getResultList();

    suppliers.forEach(System.out::println);

    System.out.println("\nSuppliers from Delhi:");
    List<Supplier> delhiSuppliers = em.createQuery("from Supplier s where s.city='Delhi'", Supplier.class).getResultList();

    delhiSuppliers.forEach(s -> System.out.println(s.getSname()));


    System.out.println("\nItems supplied by Supplier with sid = 1:");
    List<String> items = em.createQuery("select sp.item.name from Supply sp where sp.supplier.sid = 1",String.class).getResultList();

    items.forEach(System.out::println);
    em.close();
}

}
