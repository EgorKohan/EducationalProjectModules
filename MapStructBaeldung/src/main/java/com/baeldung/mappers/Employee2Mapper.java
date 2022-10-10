package com.baeldung.mappers;

import com.baeldung.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface Employee2Mapper {

    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "employeeName", source = "employee.name")
    @Mapping(target = "divisionDto", source = "employee.division")
    Employee2Dto toEmployee2Dto(Employee2 employee);

    @Mapping(target = "id", source = "employeeDto.employeeId")
    @Mapping(target = "name", source = "employeeDto.employeeName")
    @Mapping(target = "division", source = "employeeDto.divisionDto")
    Employee2 toEmployee2(Employee2Dto employeeDto);


    Division toDivision(DivisionDto divisionDto);

    DivisionDto toDivisionDto(Division division);

}
