package edu.hyf.car_rental.dto;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class CarRequestDTO {

    @NotNull(message= "Brand is required.")
    private String brand;

    @NotNull(message= "Plate is required.")
    private String plate;

    @NotNull
    @Min(value=2023, message = "Year must be >= 2023.") // @Catherine: add this to test global handle violations.
    private int year;

    private String color;
    private String model;

    @NotNull(message= "Rental is required.")
    private Boolean isRented;

    private Long rentalId;

}
