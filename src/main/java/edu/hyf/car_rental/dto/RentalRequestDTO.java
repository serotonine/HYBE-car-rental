package edu.hyf.car_rental.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data

public class RentalRequestDTO {
    @NotNull
    private Long rentalId;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate returnDate;
}
