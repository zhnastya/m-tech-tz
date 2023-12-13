package com.m.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarFullDto {
    private Long carId;
    private String name;
    private LocalDateTime dateOfCreated;
    private BodyDto bodyType;
    private WheelDto wheelType;
    private Integer wheelCount;
}
