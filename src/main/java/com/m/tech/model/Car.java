package com.m.tech.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "count_wheel")
    private Integer wheelCount;
    @Column(name = "date_of_created")
    private LocalDateTime dateTime;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Body bodyType;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Wheel wheelType;

    @PrePersist
    private void init() {
        dateTime = LocalDateTime.now();
    }
}
