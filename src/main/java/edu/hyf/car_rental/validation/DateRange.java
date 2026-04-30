package edu.hyf.car_rental.validation;

import java.time.LocalDate;

public interface DateRange {
    LocalDate getStartDate();
    LocalDate getReturnDate();
    LocalDate getExactReturnDate();
}
