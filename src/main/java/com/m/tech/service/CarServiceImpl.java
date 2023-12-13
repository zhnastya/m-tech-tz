package com.m.tech.service;

import com.m.tech.dto.BodyDto;
import com.m.tech.dto.CarFullDto;
import com.m.tech.dto.CarRequestDto;
import com.m.tech.dto.WheelDto;
import com.m.tech.exception.CarServiceException;
import com.m.tech.mapper.CarsMapper;
import com.m.tech.model.Body;
import com.m.tech.model.Car;
import com.m.tech.model.Wheel;
import com.m.tech.repository.BodyRepository;
import com.m.tech.repository.CarRepository;
import com.m.tech.repository.WheelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.m.tech.mapper.CarsMapper.carToDto;
import static com.m.tech.mapper.CarsMapper.dtoToCar;


@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final BodyRepository bodyRepository;
    private final WheelRepository wheelRepository;
    private final CarRepository carRepository;


    @Cacheable(cacheNames = "bodies")
    @Transactional(readOnly = true)
    @Override
    public List<BodyDto> getAllBody() {
        return bodyRepository.findAll().stream()
                .map(CarsMapper::bodyToDto)
                .collect(Collectors.toList());
    }

    @Cacheable(cacheNames = "wheels")
    @Transactional(readOnly = true)
    @Override
    public List<WheelDto> getAllWheels() {
        return wheelRepository.findAll().stream()
                .map(CarsMapper::wheelToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CarFullDto createCar(CarRequestDto dto) {
        Body body = bodyRepository.findById(dto.getBodyId())
                .orElseThrow(() -> new CarServiceException("Кузов с id - " + dto.getBodyId() + " не найден"));
        Wheel wheel = wheelRepository.findById(dto.getWheelId())
                .orElseThrow(() -> new CarServiceException("Колеса с id - " + dto.getWheelId() + " не найдены"));
        Car car = dtoToCar(dto);
        car.setBodyType(body);
        car.setWheelType(wheel);
        return carToDto(carRepository.save(car));
    }

    @Cacheable(cacheNames = "carById")
    @Transactional(readOnly = true)
    @Override
    public CarFullDto getCarById(Long id) {
        return carToDto(carRepository.findById(id)
                .orElseThrow(() -> new CarServiceException("Машина с id - " + id + " не найдена")));
    }

    @Cacheable(cacheNames = "page_car")
    @Transactional(readOnly = true)
    @Override
    public List<CarFullDto> getPageCar(Integer offset, Integer limit, Integer sortField) {
        Sort sort = switch (sortField) {
            case 1 -> Sort.by(Sort.Direction.DESC, "dateTime");
            case 2 -> Sort.by(Sort.Direction.ASC, "dateTime");
            case 3 -> Sort.by(Sort.Direction.ASC, "name");
            case 4 -> Sort.by(Sort.Direction.DESC, "name");
            default -> throw new CarServiceException("Значение сортировки не распознано");
        };
        return carRepository.findAll(PageRequest.of(offset, limit, sort)).getContent()
                .stream()
                .map(CarsMapper::carToDto)
                .collect(Collectors.toList());
    }
}
