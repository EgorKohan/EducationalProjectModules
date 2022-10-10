package com.baeldung.models.mappedsuperclass;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * Using the MappedSuperclass strategy, inheritance is only evident in the class but not the entity model.
 *
 * Let's start by creating a Person class that will represent a parent class:
 *
 * Notice that this class no longer has an @Entity annotation, as it won't be persisted in the database by itself.
 *
 * Next, let's add an Employee subclass:
 *
 * In the database, this will correspond to one MyEmployee table with three columns for the declared and inherited fields of the subclass.
 *
 * If we're using this strategy, ancestors cannot contain associations with other entities.
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return Objects.equals(personId, person.personId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
