package com.baeldung;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The first thing that we should discuss here is what lazy loading and eager loading are:
 *
 * Eager Loading is a design pattern in which data initialization occurs on the spot.
 * Lazy Loading is a design pattern that we use to defer initialization of an object as long as it's possible.
 * Let's see how this works.
 *
 * First, we'll look at the UserLazy class:
 *
 * One User can have multiple OrderDetails. In eager loading strategy, if we load the User data, it will also load up all orders associated with it and will store it in a memory.
 *
 * But when we enable lazy loading, if we pull up a UserLazy, OrderDetail data won't be initialized and loaded into a memory until we make an explicit call to it.
 *
 * In the next section, we'll see how we implement the example in Hibernate.
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "USERS")
public class UserLazy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userLazy", cascade = CascadeType.PERSIST)
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserLazy userLazy = (UserLazy) o;
        return userId != null && Objects.equals(userId, userLazy.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
