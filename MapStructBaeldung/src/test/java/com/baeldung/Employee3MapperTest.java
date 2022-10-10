package com.baeldung;

import com.baeldung.mappers.Employee3Mapper;
import com.baeldung.models.Employee3;
import com.baeldung.models.Employee3Dto;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Slf4j
class Employee3MapperTest {

    private final Employee3Mapper employee3Mapper = Mappers.getMapper(Employee3Mapper.class);

    @Test
    void test() {
        Employee3 employee3 = new Employee3();
        employee3.setStartDate(new Date());
        Employee3Dto employee3Dto = employee3Mapper.toEmployee3Dto(employee3);
        log.info("employee3: {}, dto: {}", employee3, employee3Dto);
        MatcherAssert.assertThat(employee3.getStartDate(), Matchers.instanceOf(Date.class));
        MatcherAssert.assertThat(employee3Dto.getStartDate(), Matchers.instanceOf(String.class));
    }

}
