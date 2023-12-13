package com.m.tech.controller;

import com.m.tech.dto.BodyDto;
import com.m.tech.dto.CarFullDto;
import com.m.tech.dto.CarRequestDto;
import com.m.tech.dto.WheelDto;
import com.m.tech.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Car Service", description = "Car management APIs")
@Slf4j
@RestController
@RequestMapping(path = "/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService service;

    @Operation(
            summary = "Get all type of body",
            description = "Get a bodyType objects.The response is List of bodies with id, " +
                    "type.",
            tags = {"bodies", "get"})
    @GetMapping("/bodies")
    public List<BodyDto> getAllCarBody() {
        log.info("Запрос на получение всех типов кузовов");
        return service.getAllBody();
    }


    @Operation(
            summary = "Get all type of wheel",
            description = "Get a wheelType objects.The response is List of wheels with id, " +
                    "type.",
            tags = {"wheels", "get"})
    @GetMapping("/wheels")
    public List<WheelDto> getAllCarWheels() {
        log.info("Запрос на получение всех типов колес");
        return service.getAllWheels();
    }


    @Operation(
            summary = "Save a car",
            description = "Save a car. The response is car object with id, " +
                    "name, dateOfCreated, bodyType object, wheelType object and count of wheel.",
            tags = {"cars", "post"})
    @PostMapping
    public CarFullDto createCar(@Valid @RequestBody CarRequestDto dto) {
        log.info("Запрос на сохранение автомобиля");
        return service.createCar(dto);
    }


    @Operation(
            summary = "Get a car by id",
            description = "Get a car by id. The response is car object with id, " +
                    "name, dateOfCreated, bodyType object, wheelType object and count of wheel.",
            tags = {"cars", "get"})
    @GetMapping("/{id}")
    public CarFullDto getCarById(@PathVariable Long id) {
        log.info("Запрос на получение автомобиля по id - " + id);
        return service.getCarById(id);
    }


    @Operation(
            summary = "Get page of cars with sort",
            description = "Get page of cars with sort (date_of_created: 1-desc, 2-asc; name: 3-asc, 4-desc). " +
                    "The response is list of cars with id, name, dateOfCreated, bodyType object, " +
                    "wheelType object and count of wheel.",
            tags = {"cars", "get"})
    @GetMapping
    public List<CarFullDto> getCars(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                    @RequestParam(value = "sort", defaultValue = "1") Integer sortField) {
        log.info("Запрос на получение страницы с автомобилями");
        return service.getPageCar(offset, limit, sortField);
    }
}
