package com.baeldung.mappers;

import com.baeldung.models.Person;
import com.baeldung.models.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    PersonDto toPersonDto(Person person);

}
