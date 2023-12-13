package com.m.tech.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDto {
    @NotNull(message = "укажите id типа корпуса")
    private Long bodyId;
    @NotNull(message = "укажите id типа колес")
    private Long wheelId;
    @Min(value = 2, message = "минимальное колличество колес - 2шт")
    private Integer wheelCount;
    @NotBlank(message = "укажите крутое название для автомобиля")
    private String name;
}
