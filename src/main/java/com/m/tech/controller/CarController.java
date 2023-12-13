package com.m.tech.controller;

import com.m.tech.dto.BodyDto;
import com.m.tech.dto.CarFullDto;
import com.m.tech.dto.CarRequestDto;
import com.m.tech.dto.WheelDto;
import com.m.tech.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService service;

    @GetMapping("/bodies")
    public List<BodyDto> getAllCarBody() {
        log.info("Запрос на получение всех типов кузовов");
        return service.getAllBody();
    }

    @GetMapping("/wheels")
    public List<WheelDto> getAllCarWheels() {
        log.info("Запрос на получение всех типов колес");
        return service.getAllWheels();
    }

    @PostMapping
    public CarFullDto createCar(@Valid @RequestBody CarRequestDto dto) {
        log.info("Запрос на сохранение автомобиля");
        return service.createCar(dto);
    }

    @GetMapping("/{id}")
    public CarFullDto getCarById(@PathVariable Long id) {
        log.info("Запрос на получение автомобиля по id - " + id);
        return service.getCarById(id);
    }

    @GetMapping
    public List<CarFullDto> getCars(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                    @RequestParam(value = "sort", defaultValue = "1") Integer sortField) {
        log.info("Запрос на получение страницы с автомобилями");
        return service.getPageCar(offset, limit, sortField);
    }
}
