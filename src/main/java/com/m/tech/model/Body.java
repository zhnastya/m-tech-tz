package com.m.tech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bodies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_body")
    @Enumerated(value = EnumType.STRING)
    private TypeBody typeBody;
}
