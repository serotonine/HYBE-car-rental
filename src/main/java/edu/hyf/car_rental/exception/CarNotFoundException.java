package edu.hyf.car_rental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends NoSuchElementException {
    public CarNotFoundException(Long id){
        super("Car with id " + id +" does not exist.");
    }
}
