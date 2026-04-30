package edu.hyf.car_rental.dto;

import edu.hyf.car_rental.validation.DateRange;
import edu.hyf.car_rental.validation.EndDateAfterStartDate;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@EndDateAfterStartDate
public class RentalRequestDTO  implements DateRange {
    @NotNull(message = "Rental id is required.")
    private Long rentalId;
    @NotNull(message = "Start date is required.")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private LocalDate startDate;
    @NotNull(message = "Return date is required.")
    private LocalDate returnDate;
    private LocalDate exactReturnDate;
    @NotNull(message = "Car id is required.")
    private Long carId;
}
