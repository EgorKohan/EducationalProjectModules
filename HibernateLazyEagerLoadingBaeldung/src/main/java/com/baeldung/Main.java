package com.baeldung;

import com.baeldung.config.CustomSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = CustomSessionFactory.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserLazy userLazy = new UserLazy();
        OrderDetail orderDetail = new OrderDetail();
        userLazy.setOrderDetails(Set.of(orderDetail));
        session.save(userLazy);

        session.getTransaction().commit();

        List<UserLazy> fromUserLazy = session.createQuery("from UserLazy", UserLazy.class).getResultList();

        session.close();
    }

}
