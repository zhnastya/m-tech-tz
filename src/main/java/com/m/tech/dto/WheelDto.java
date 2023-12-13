package com.m.tech.dto;

import com.m.tech.model.TypeWheel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WheelDto {
    private Long id;
    private TypeWheel type;
}
