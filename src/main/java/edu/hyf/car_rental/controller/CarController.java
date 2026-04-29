package edu.hyf.car_rental.controller;

import edu.hyf.car_rental.dto.CarRequestDTO;
import edu.hyf.car_rental.dto.CarResponseDTO;
import edu.hyf.car_rental.model.Car;
import edu.hyf.car_rental.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {
    private final CarService service;

    public CarController(CarService service){
        this.service = service;
    }

    // GET
    @GetMapping("")
    public List<CarResponseDTO> findAllCars(){
        return service.findAllCars();
    }
    @GetMapping("/{carId}")
    public CarResponseDTO findCarById(@PathVariable Long carId ){
        return service.findCarById(carId);
    }

    public List<Car> findAllAvailableCars(){
        return service.findAllAvailableCars();
    }

    /* POST */
    // ADD NEW CAR => add in car
    @PostMapping("add")
    public CarResponseDTO addCar(@Valid @RequestBody CarRequestDTO carDTO){
        return service.addCar(carDTO);
    }
    /* DELETE */
    @DeleteMapping("delete/{carId}")
    public ResponseEntity<?> deleteCar(@PathVariable Long carId){
        return service.deleteCar(carId);

    }

}
