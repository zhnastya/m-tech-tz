package com.m.tech.service;

import com.m.tech.dto.BodyDto;
import com.m.tech.dto.CarFullDto;
import com.m.tech.dto.CarRequestDto;
import com.m.tech.dto.WheelDto;

import java.util.List;

public interface CarService {
    List<BodyDto> getAllBody();

    List<WheelDto> getAllWheels();

    CarFullDto createCar(CarRequestDto dto);

    CarFullDto getCarById(Long id);

    List<CarFullDto> getPageCar(Integer offset, Integer limit, Integer sortField);
}
