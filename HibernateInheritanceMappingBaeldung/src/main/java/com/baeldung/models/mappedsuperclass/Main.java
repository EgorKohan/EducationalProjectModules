package com.baeldung.models.mappedsuperclass;

import com.baeldung.models.config.CustomSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        MyEmployee myEmployee = new MyEmployee();
        myEmployee.setName("Egor");
        myEmployee.setCompany("NetCracker");
        SessionFactory sessionFactory = CustomSessionFactory.sessionFactory();
        Session session = sessionFactory.openSession();
        session.save(myEmployee);
        session.close();
    }

}
