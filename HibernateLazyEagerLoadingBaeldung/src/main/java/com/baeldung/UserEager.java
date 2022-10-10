package com.baeldung;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "USERS")
public class UserEager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userLazy")
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEager userLazy = (UserEager) o;
        return userId != null && Objects.equals(userId, userLazy.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
