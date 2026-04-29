package edu.hyf.car_rental.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CarStatus {
    AVAILABLE,
    RENTED;

    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }
}
