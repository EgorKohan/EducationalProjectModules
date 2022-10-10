package com.baeldung;

import com.baeldung.mappers.CarMapper;
import com.baeldung.models.Car;
import com.baeldung.models.CarDto;
import com.baeldung.models.ElectricCar;
import com.baeldung.models.FuelType;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.hamcrest.Matchers.is;

class CarMapperTest {

    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    @Test
    void test() {
        Car car = new ElectricCar();
        car.setId(1);
        car.setName("Tesla");
        CarDto carDto = carMapper.toCarDto(car);

        MatcherAssert.assertThat(carDto.getFuelType(), is(FuelType.ELECTRIC));
    }
}
