package com.baeldung.models.joinedtable;

import com.baeldung.models.config.CustomSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = CustomSessionFactory.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Pet pet = new Pet();
        pet.setName("Barsik");
        pet.setSpecies("Cat");
        session.save(pet);

        WildAnimal wildAnimal = new WildAnimal();
        wildAnimal.setSpecies("Tiger");
        wildAnimal.setAttack(1000);
        session.save(wildAnimal);

        session.getTransaction().commit();

        List<Pet> fromPet = session.createQuery("from Pet", Pet.class).getResultList();
        List<Animal> fromAnimal = session.createQuery("from Animal", Animal.class).getResultList();
        System.out.println(fromPet.size());
        System.out.println(fromAnimal.size());

        session.close();
    }

}
