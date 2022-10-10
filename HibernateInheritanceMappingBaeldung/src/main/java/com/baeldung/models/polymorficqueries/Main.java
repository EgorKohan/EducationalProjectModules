package com.baeldung.models.polymorficqueries;

import com.baeldung.models.config.CustomSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = CustomSessionFactory.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Bag bag = new Bag();
        bag.setName("Backpack");
        bag.setWeight(100.5f);
        session.save(bag);

        session.getTransaction().commit();

        List<Item> fromItem = session.createQuery("from Item", Item.class).getResultList();
        System.out.println(fromItem.size());
        System.out.println(fromItem.get(0).getClass().getSimpleName().equals(Item.class.getSimpleName())); // ??? по сути тут должен быть Item из-за полиформфоного поведения

        session.close();
    }

}
