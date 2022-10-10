package com.baeldung.mappers;

import com.baeldung.models.Employee;
import com.baeldung.models.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "employeeName", source = "employee.name")
    EmployeeDto toEmployeeDto(Employee employee);

    @Mapping(target = "id", source = "employeeDto.employeeId")
    @Mapping(target = "name", source = "employeeDto.employeeName")
    Employee toEmployee(EmployeeDto employeeDto);

}
