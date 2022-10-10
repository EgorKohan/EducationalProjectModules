package com.baeldung.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = CustomSessionFactory.sessionFactory();
        Session session = sessionFactory.openSession();
        Company company = new Company();
        company.setName("NetCracker");
        company.setAddress("Dz57");
        company.setPhone("777");
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setFirstName("Egor");
        contactPerson.setLastName("Kokhan");
        contactPerson.setPhone("0418");
        company.setContactPerson(contactPerson);
        session.save(company);

        Query<Company> fromCompany = session.createQuery("from Company", Company.class);
        List<Company> resultList = fromCompany.getResultList();

        session.close();

        assert !resultList.isEmpty();

    }

}
