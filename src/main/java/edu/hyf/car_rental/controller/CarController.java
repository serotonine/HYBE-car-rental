package edu.hyf.car_rental.controller;

import edu.hyf.car_rental.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
public class CarController {
    private final CarService service;

    public CarController(CarService service){
        this.service = service;
    }

    // GET
    @GetMapping("")
    public List<Car> findAllCars(){
        return service.findAll();
    }

    public List<Car> findAllAvailableCars(){
        return service.findAllAvailableCars();
    }

    /* POST */
    // ADD NEW CAR => add in car
    @PostMapping("add")
    public ResponseEntity<?> addCar( @Valid @RequestBody CarRequestDTO carDTO){
        return service.addCar(carDTO);
    }
    /* DELETE */
    @DeleteMapping("delete/{carId}")
    public ResponseEntity<?> deleteCar(@PathVariable Long carId){
        return service.deleteCar(carId);

    }

}
