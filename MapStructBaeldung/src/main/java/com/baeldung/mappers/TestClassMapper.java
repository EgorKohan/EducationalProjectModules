package com.baeldung.mappers;

import com.baeldung.models.TestClass;
import com.baeldung.models.TestClassDto;
import com.baeldung.models.TestClassType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestClassMapper {

    TestClassMapper INSTANCE = Mappers.getMapper(TestClassMapper.class);

    @Mapping(target = "type", source = "type")
    TestClass toTestClass(TestClassDto dto, TestClassType type);

    TestClassDto toDto(TestClass testClass);

}
