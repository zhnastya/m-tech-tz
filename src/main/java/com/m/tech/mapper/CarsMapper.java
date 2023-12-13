package com.m.tech.mapper;

import com.m.tech.dto.BodyDto;
import com.m.tech.dto.CarFullDto;
import com.m.tech.dto.CarRequestDto;
import com.m.tech.dto.WheelDto;
import com.m.tech.model.Body;
import com.m.tech.model.Car;
import com.m.tech.model.Wheel;

public class CarsMapper {
    public static WheelDto wheelToDto(Wheel wheel) {
        return WheelDto.builder()
                .id(wheel.getId())
                .type(wheel.getTypeWheel())
                .build();
    }

    public static BodyDto bodyToDto(Body body) {
        return BodyDto.builder()
                .id(body.getId())
                .type(body.getTypeBody())
                .build();
    }

    public static Car dtoToCar(CarRequestDto dto) {
        return Car.builder()
                .name(dto.getName())
                .wheelCount(dto.getWheelCount())
                .build();
    }

    public static CarFullDto carToDto(Car car) {
        return CarFullDto.builder()
                .carId(car.getId())
                .name(car.getName())
                .bodyType(bodyToDto(car.getBodyType()))
                .wheelType(wheelToDto(car.getWheelType()))
                .dateOfCreated(car.getDateTime())
                .wheelCount(car.getWheelCount())
                .build();
    }
}
