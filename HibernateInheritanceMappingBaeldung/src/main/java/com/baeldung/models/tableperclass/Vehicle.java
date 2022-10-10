package com.baeldung.models.tableperclass;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Table per Class strategy maps each entity to its table, which contains all the properties of the entity, including the ones inherited.
 *
 * The resulting schema is similar to the one using @MappedSuperclass. But Table per Class will indeed define entities for parent classes, allowing associations and polymorphic queries as a result.
 *
 * To use this strategy, we only need to add the @Inheritance annotation to the base class:
 *
 * Then we can create the subclasses in the standard way.
 *
 * This is not that different from merely mapping each entity without inheritance. The distinction is clear when querying the base class, which will return all the subclass records as well by using a UNION statement in the background.
 *
 * The use of UNION can also lead to inferior performance when choosing this strategy. Another issue is that we can no longer use identity key generation.
 *
 * <b>Have to use     @GeneratedValue(strategy = GenerationType.TABLE)</b>
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long vehicleId;

    private String manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleId, vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
