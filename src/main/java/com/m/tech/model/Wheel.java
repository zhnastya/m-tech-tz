package com.m.tech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wheels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_wheel")
    @Enumerated(value = EnumType.STRING)
    private TypeWheel typeWheel;
}
