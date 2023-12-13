package com.m.tech.model;

import java.util.Optional;

public enum TypeBody {
    Hatchback,
    Sedan,
    Sports;

    public static Optional<TypeBody> from(String type) {
        for (TypeBody state : values()) {
            if (state.name().equalsIgnoreCase(type)) {
                return Optional.of(state);
            }
        }
        return Optional.empty();
    }
}
