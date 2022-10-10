package com.baeldung.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomSessionFactory {

    private static SessionFactory sessionFactory;

    private static Properties config() {
        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/lazy_eager_loading");

        //You can use any database you want, I had it configured for Postgres
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "root");
        prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("show_sql", "true"); //If you wish to see the generated sql query
        return prop;
    }

    @SneakyThrows
    public static SessionFactory sessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .addProperties(config());
            List<Class<?>> classes = getEntityClassesFromPackage("com.baeldung");
            classes.forEach(configuration::addAnnotatedClass);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    private static List<Class<?>> getEntityClassesFromPackage(String packageName) throws URISyntaxException, ClassNotFoundException {
        List<String> classNames = getClassNamesFromPackage(packageName);
        List<Class<?>> classes = new ArrayList<>();

        for (String className : classNames) {
            Class<?> cls = Class.forName(className);
            Annotation[] annotations = cls.getAnnotations();

            for (Annotation annotation : annotations) {
                System.out.println(cls.getCanonicalName() + ":" + annotation.toString());
                if (annotation instanceof Entity) {
                    classes.add(cls);
                }
            }

        }
        return classes;
    }

    private static List<String> getClassNamesFromPackage(String packageName) throws URISyntaxException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ArrayList<String> names = new ArrayList<>();

        packageName = packageName.replace(".", "/");
        URL packageUrl = classLoader.getResource(packageName);

        URI uri = new URI(packageUrl.toString());
        File folder = new File(uri.getPath());
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                names.addAll(getClassNamesFromPackage(packageName + "." + file.getName()));
            } else {
                String name = packageName.replace("/", ".") + "." + file.getName();
                name = name.substring(0, name.lastIndexOf('.'));
                names.add(name);
            }
        }

        return names;
    }

}
