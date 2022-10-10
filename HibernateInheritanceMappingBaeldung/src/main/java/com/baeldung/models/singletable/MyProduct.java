package com.baeldung.models.singletable;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Single Table strategy creates one table for each class hierarchy. JPA also chooses this strategy by default if we don't specify one explicitly.
 *
 * We can define the strategy we want to use by adding the @Inheritance annotation to the superclass:
 *
 * Hibernate adds two other predefined values that the annotation can take — null and not null:
 *
 * @DiscriminatorValue(“null”) means that any row without a
 * discriminator value will be mapped to the entity class with this annotation;
 * this can be applied to the root class of the hierarchy.
 * @DiscriminatorValue(“not null”) – Any row with a discriminator value not matching any
 * of the ones associated with entity definitions will be mapped to the class with this annotation.
 *
 * Instead of a column, we can also use the Hibernate-specific @DiscriminatorFormula annotation to determine the differentiating values:
 *
 * This strategy has the advantage of polymorphic query performance since only one table needs to be accessed when querying parent entities.
 *
 * On the other hand, this also means that we can no longer use NOT NULL constraints on subclass entity properties.
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.INTEGER)
public class MyProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MyProduct myProduct = (MyProduct) o;
        return name.equals(myProduct.name) && Objects.equals(productId, myProduct.productId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
