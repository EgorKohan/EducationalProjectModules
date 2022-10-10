package com.baeldung.models;

import lombok.Data;

@Data
public class Employee2Dto {

    private int employeeId;

    private String employeeName;

    private DivisionDto divisionDto;

}
