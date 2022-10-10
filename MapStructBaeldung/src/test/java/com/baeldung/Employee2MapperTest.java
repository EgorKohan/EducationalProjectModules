package com.baeldung;

import com.baeldung.mappers.Employee2Mapper;
import com.baeldung.mappers.EmployeeMapper;
import com.baeldung.models.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
class Employee2MapperTest {

    private final Employee2Mapper employeeMapper = Mappers.getMapper(Employee2Mapper.class);

    @Test
    void test() {
        Employee2 employee = new Employee2();
        employee.setId(1);
        employee.setName("Egor");
        employee.setDivision(new Division(1, "div1"));
        Employee2Dto employeeDto = employeeMapper.toEmployee2Dto(employee);
        log.info("employee: {}, dto: {}", employee, employeeDto);
        assertThat(employee.getId(), is(employeeDto.getEmployeeId()));
        assertThat(employee.getName(), is(employeeDto.getEmployeeName()));
        assertThat(employee.getDivision().getId(), is(employeeDto.getDivisionDto().getId()));
        assertThat(employee.getDivision().getName(), is(employeeDto.getDivisionDto().getName()));
    }

    @Test
    void test2() {
        Employee2Dto employeeDto = new Employee2Dto();
        employeeDto.setEmployeeId(1);
        employeeDto.setEmployeeName("Egor");
        employeeDto.setDivisionDto(new DivisionDto(1, "div1"));
        Employee2 employee = employeeMapper.toEmployee2(employeeDto);
        log.info("employee: {}, dto: {}", employee, employeeDto);
        assertThat(employee.getId(), is(employeeDto.getEmployeeId()));
        assertThat(employee.getName(), is(employeeDto.getEmployeeName()));
        assertThat(employee.getDivision().getId(), is(employeeDto.getDivisionDto().getId()));
        assertThat(employee.getDivision().getName(), is(employeeDto.getDivisionDto().getName()));
    }

}
