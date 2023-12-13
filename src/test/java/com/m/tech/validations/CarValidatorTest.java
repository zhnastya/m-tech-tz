package com.m.tech.validations;

import com.m.tech.dto.CarRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarValidatorTest {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.usingContext().getValidator();

    @Test
    @DisplayName("Если id кузова == null")
    void shouldCheckIfIdBodyNotContaining() {
        final CarRequestDto dto = new CarRequestDto(null, 1L, 3, "name");

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);
        String message = validates.stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse("");

        assertEquals(1, validates.size());
        assertEquals(message, "укажите id типа корпуса");
    }

    @Test
    @DisplayName("Если id кузова != null")
    void shouldCheckIfIdBodyContaining() {
        final CarRequestDto dto = new CarRequestDto(1L, 1L, 3, "name");

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);

        assertEquals(0, validates.size());
    }

    @Test
    @DisplayName("Если id колес == null")
    void shouldCheckIfIdWheelNotContaining() {
        final CarRequestDto dto = new CarRequestDto(1L, null, 3, "name");

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);
        String message = validates.stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse("");

        assertEquals(1, validates.size());
        assertEquals(message, "укажите id типа колес");
    }

    @Test
    @DisplayName("Если id колес != null")
    void shouldCheckIfIdWheelContaining() {
        final CarRequestDto dto = new CarRequestDto(1L, 1L, 3, "name");

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);

        assertEquals(0, validates.size());
    }

    @Test
    @DisplayName("Если колличество колес < 2")
    void shouldCheckIfCountWheelLess2() {
        final CarRequestDto dto = new CarRequestDto(1L, 1L, 1, "name");

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);
        String message = validates.stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse("");

        assertEquals(1, validates.size());
        assertEquals(message, "минимальное колличество колес - 2шт");
    }

    @Test
    @DisplayName("Если колличество колес = 2")
    void shouldCheckIfCountWheelEquals2() {
        final CarRequestDto dto = new CarRequestDto(1L, 1L, 2, "name");

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);

        assertEquals(0, validates.size());
    }

    @Test
    @DisplayName("Если колличество колес > 2")
    void shouldCheckIfCountWheelMoreThen2() {
        final CarRequestDto dto = new CarRequestDto(1L, 1L, 3, "name");

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);

        assertEquals(0, validates.size());
    }

    @Test
    @DisplayName("Если название машины == null")
    void shouldCheckIfNameNull() {
        final CarRequestDto dto = new CarRequestDto(1L, 1L, 3, null);

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);
        String message = validates.stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse("");

        assertEquals(1, validates.size());
        assertEquals(message, "укажите крутое название для автомобиля");
    }

    @Test
    @DisplayName("Если название машины != null")
    void shouldCheckIfNameNotNull() {
        final CarRequestDto dto = new CarRequestDto(1L, 1L, 3, "name");

        Set<ConstraintViolation<CarRequestDto>> validates = validator.validate(dto);

        assertEquals(0, validates.size());
    }
}
