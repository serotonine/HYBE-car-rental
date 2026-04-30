package edu.hyf.car_rental.dto;

<<<<<<< Updated upstream
import jakarta.validation.constraints.Future;
=======
import edu.hyf.car_rental.validation.DateRange;
import edu.hyf.car_rental.validation.EndDateAfterStartDate;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
>>>>>>> Stashed changes
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.lang.annotation.Annotation;
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
<<<<<<< Updated upstream
    @NotNull
    private Long carId;
=======
    @NotNull(message = "Car id is required.")
    private Long carId;

>>>>>>> Stashed changes
}
