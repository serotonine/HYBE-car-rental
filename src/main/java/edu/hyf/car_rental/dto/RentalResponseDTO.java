package edu.hyf.car_rental.dto;
import lombok.Data;

import java.time.LocalDate;


@Data

public class RentalResponseDTO {
    private Long id;
    private Long rentalId;
    private LocalDate startDate;
    private LocalDate returnDate;
    private LocalDate exactReturnDate;
}
