package com.baeldung.mappers;

import com.baeldung.models.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class CarMapper {

    @BeforeMapping
    protected void enrichDTOWithFuelType(Car car, @MappingTarget CarDto carDto) {
        if (car instanceof ElectricCar) {
            carDto.setFuelType(FuelType.ELECTRIC);
        } else if (car instanceof BioDieselCar) {
            carDto.setFuelType(FuelType.BIODIESEL);
        }
    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget CarDto carDto) {
        carDto.setName(carDto.getName().toUpperCase());
    }

    public abstract CarDto toCarDto(Car car);

}
