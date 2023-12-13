package com.m.tech.dto;

import com.m.tech.model.TypeBody;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BodyDto {
    private Long id;
    private TypeBody type;
}
