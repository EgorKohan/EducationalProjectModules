package com.baeldung.models.tableperclass;

import com.baeldung.models.config.CustomSessionFactory;
import com.baeldung.models.joinedtable.Animal;
import com.baeldung.models.joinedtable.Pet;
import com.baeldung.models.joinedtable.WildAnimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = CustomSessionFactory.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        MotorVehicle motorVehicle = new MotorVehicle();
        motorVehicle.setManufacturer("RAM");
        motorVehicle.setPowerOfEngine(1000);
        session.save(motorVehicle);

        UtilityVehicle utilityVehicle = new UtilityVehicle();
        utilityVehicle.setManufacturer("MAZ");
        utilityVehicle.setCountOfWheels(8);
        session.save(utilityVehicle);

        session.getTransaction().commit();

        List<Vehicle> fromVehicle = session.createQuery("from Vehicle", Vehicle.class).getResultList();

        session.close();
    }

}
