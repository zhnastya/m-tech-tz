package com.m.tech.model;

import java.util.Optional;

public enum TypeWheel {
    R16,
    R15,
    R17;

    public static Optional<TypeWheel> from(String type) {
        for (TypeWheel state : values()) {
            if (state.name().equalsIgnoreCase(type)) {
                return Optional.of(state);
            }
        }
        return Optional.empty();
    }
}
