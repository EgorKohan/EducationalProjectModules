package com.baeldung.models.joinedtable;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


/**
 * Using this strategy, each class in the hierarchy is mapped to its table.
 * The only column that repeatedly appears in all the tables is the identifier,
 * which will be used for joining them when needed.
 *
 * Let's create a superclass that uses this strategy:
 *
 * Both tables will have an animalId identifier column.
 *
 * The primary key of the Pet entity also has a foreign key constraint to the primary key of its parent entity.
 *
 * To customize this column, we can add the @PrimaryKeyJoinColumn annotation:
 *
 * The disadvantage of this inheritance mapping method is that retrieving entities requires joins between tables, which can result in lower performance for large numbers of records.
 *
 * The number of joins is higher when querying the parent class because it will join with every single related child — so performance is more likely to be affected the higher up the hierarchy we want to retrieve records.
 *
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long animalId;
    private String species;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animalId, animal.animalId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
