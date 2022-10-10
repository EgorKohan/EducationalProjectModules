package com.baeldung;

import com.baeldung.mappers.EmployeeMapper;
import com.baeldung.models.Employee;
import com.baeldung.models.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
class EmployeeMapperTest {

    private EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

    @Test
    void test() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Egor");
        EmployeeDto employeeDto = employeeMapper.toEmployeeDto(employee);
        log.info("employee: {}, dto: {}", employee, employeeDto);
        assertThat(employee.getId(), is(employeeDto.getEmployeeId()));
        assertThat(employee.getName(), is(employeeDto.getEmployeeName()));
    }

    @Test
    void test2() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(1);
        employeeDto.setEmployeeName("Egor");
        Employee employee = employeeMapper.toEmployee(employeeDto);
        log.info("employee: {}, dto: {}", employee, employeeDto);
        assertThat(employee.getId(), is(employeeDto.getEmployeeId()));
        assertThat(employee.getName(), is(employeeDto.getEmployeeName()));
    }

}
