package com.test.web.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usual_person")
public class UsualPerson extends Person{

    public UsualPerson(String id, String name) {
        super(id, name);
    }
}
