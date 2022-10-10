package com.test.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperPersonRepository extends MongoRepository<SuperPerson, String>, PersonRepository<SuperPerson, String> {


}
