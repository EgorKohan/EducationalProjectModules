package com.test.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsualPersonRepository extends MongoRepository<UsualPerson, String>, PersonRepository<UsualPerson
        , String> {
}
