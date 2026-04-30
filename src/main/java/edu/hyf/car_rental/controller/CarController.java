package edu.hyf.car_rental.controller;

import edu.hyf.car_rental.dto.CarRequestDTO;
import edu.hyf.car_rental.dto.CarResponseDTO;
import edu.hyf.car_rental.dto.CarUpdateRequestDTO;
import edu.hyf.car_rental.model.Car;
import edu.hyf.car_rental.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
@Validated
public class CarController {
    private final CarService service;

    public CarController(CarService service){
        this.service = service;
    }

    /* GET */
    // Get all.
    @GetMapping("")
    public List<CarResponseDTO> findAllCars(){
        return service.findAllCars();
    }
    // Get by id.
    @GetMapping("/{carId}")
    public CarResponseDTO findCarById(@PathVariable Long carId ){
        return service.findCarById(carId);
    }

    public List<Car> searchCarBy(){
        return service.searchBy();
    }

    /* POST */
    // ADD NEW CAR => add in car
    @PostMapping("add")
    public ResponseEntity<?> addCar(@Valid @RequestBody CarRequestDTO carDTO){
        return service.addCar(carDTO);
    }

    /* PATCH */
@PatchMapping("update/{id}")
    public ResponseEntity<?> updateCar(
            @PathVariable Long id,
            @Valid @RequestBody CarUpdateRequestDTO dto
){
        return service.updateCar(id, dto);
    }

    /* DELETE */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
        return service.deleteCar(id);
    }
}
