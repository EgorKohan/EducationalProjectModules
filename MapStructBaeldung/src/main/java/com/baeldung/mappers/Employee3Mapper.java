package com.baeldung.mappers;

import com.baeldung.models.Employee3;
import com.baeldung.models.Employee3Dto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface Employee3Mapper {

    @Mapping(target = "startDate", dateFormat = "dd-MM-yyyy HH:mm:ss")
    Employee3 toEmployee3(Employee3Dto employee3Dto);

    @Mapping(target = "startDate", dateFormat = "dd-MM-yyyy HH:mm:ss")
    Employee3Dto toEmployee3Dto(Employee3 employee3);

}
