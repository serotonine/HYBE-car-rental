package edu.hyf.car_rental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class CarResponseDTO {

    private Long id;

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


}
