package com.baeldung.models;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomSessionFactory {

    private static SessionFactory sessionFactory;

    private static Properties config() {
        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");

        //You can use any database you want, I had it configured for Postgres
        prop.setProperty("dialect", "org.hibernate.dialect.H2Dialect");

        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "root");
        prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        prop.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        prop.setProperty("show_sql", "true"); //If you wish to see the generated sql query
        return prop;
    }

    public static SessionFactory sessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .addProperties(config())
                    .addAnnotatedClass(Company.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

}
