package edu.hyf.car_rental.controller;

import edu.hyf.car_rental.model.Rental;
import edu.hyf.car_rental.service.RentalService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("rent")
public class RentalController {
    private RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }
     /* GET */
/*    @GetMapping("")
    public List<Rental> findAllRentals(){
        return service.findAllRentals();
    }
    @GetMapping("search/{carId}")
    public List<Rental> findBy(@PathVariable Long carId){
        return service.findAllRentals(carId);
    }*/

    /* POST */
  /*  @PostMapping("add")
    public ResponseEntity<?> addRental(
            @Valid @RequestBody RentalRequestDTO dto;
    ){
        return service.addRental();
    }*/
    /* DELETE */
    /* @DeleteMapping("delete/{carId}")
   public ResponseEntity<?> addRental(
            @PathVariable Long rentalId
    ){
        return service.deleteRental();
    }*/

    // RENT => add in Rental


    // RETURN =>
  /*  @DeleteMapping("return/{id}")
    public ResponseEntity<?> returnRentCar(
            @PathVariable Long id
    ){
        return service.
    }*/
}
