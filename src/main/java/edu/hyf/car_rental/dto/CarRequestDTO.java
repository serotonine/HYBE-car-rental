package edu.hyf.car_rental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class CarRequestDTO {

    @NotNull
    private String brand;

    @NotNull
    private String plate;

    @NotNull
    private int year;

    private String color;
    private String model;

    @NotNull
    private Boolean isRented;

    private Long rentalId;

}
