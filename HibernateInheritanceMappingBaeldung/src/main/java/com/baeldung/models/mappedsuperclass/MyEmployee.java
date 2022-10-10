package com.baeldung.models.mappedsuperclass;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Setter
@Getter
public class MyEmployee extends Person {

    private String company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MyEmployee that = (MyEmployee) o;
        return that.company.equals(company) && Objects.equals(getPersonId(), that.getPersonId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
