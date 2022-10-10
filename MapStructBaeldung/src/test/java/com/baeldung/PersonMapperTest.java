package com.baeldung;

import com.baeldung.mappers.PersonMapper;
import com.baeldung.models.Person;
import com.baeldung.models.PersonDto;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class PersonMapperTest {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Test
    void test() {
        Person person = new Person();
        person.setName("Egor");
        PersonDto personDto = personMapper.toPersonDto(person);

        MatcherAssert.assertThat(personDto.getId(), Matchers.notNullValue());

    }

}
