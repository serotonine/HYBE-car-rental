package edu.hyf.car_rental.dto;

import edu.hyf.car_rental.model.CarStatus;
import lombok.Data;

@Data
public class CarUpdateRequestDTO {

    private String brand;
    private String plate;
    private Integer year;
    private String color;
    private String model;
    private CarStatus status;

}
