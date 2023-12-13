package com.m.tech.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final String error;
    private String stackTrace;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public ErrorResponse(String error, String stackTrace) {
        this.error = error;
        this.stackTrace = stackTrace;
    }
}
