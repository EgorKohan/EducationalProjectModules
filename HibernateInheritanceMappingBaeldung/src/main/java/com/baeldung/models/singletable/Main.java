package com.baeldung.models.singletable;

import com.baeldung.models.config.CustomSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = CustomSessionFactory.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Book book = new Book();
        book.setName("War and piece");
        book.setAuthor("Xz");
        session.save(book);


        Pen pen = new Pen();
        pen.setName("Some pen");
        pen.setColor("Red");
        session.save(pen);

        session.getTransaction().commit();

        List<MyProduct> myProducts = session.createQuery("from MyProduct", MyProduct.class).getResultList();
        System.out.println(myProducts.size());

        session.close();
    }

}
