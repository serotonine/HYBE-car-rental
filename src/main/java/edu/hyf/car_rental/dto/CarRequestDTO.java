package edu.hyf.car_rental.dto;

import edu.hyf.car_rental.model.CarStatus;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class CarRequestDTO {

    @NotBlank(message= "Brand is required.")
    private String brand;

    @NotBlank(message= "Plate is required.")
    private String plate;

    @NotNull
    @Min(value=2023, message = "Year must be >= 2023.")
    private int year;

    private String color;
    private String model;

    @NotNull(message= "Status is required.")
    private CarStatus status;

}
