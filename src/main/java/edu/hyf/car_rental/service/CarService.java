package edu.hyf.car_rental.service;

import edu.hyf.car_rental.dto.CarRequestDTO;
import edu.hyf.car_rental.dto.CarResponseDTO;
import edu.hyf.car_rental.exception.CarNotFoundException;
import edu.hyf.car_rental.mapper.CarMapper;
import edu.hyf.car_rental.model.Car;
import edu.hyf.car_rental.repository.CarRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class CarService {
    private final CarRepository crepo;
    private final CarMapper mapper;

    public CarService(CarRepository repo,CarMapper mapper ){
        this.crepo = repo;
    }
    // GET
    public List<CarResponseDTO> findAllCars(){
        return crepo.findAll().stream().map(mapper::toEntity).toList();
    }
    public CarResponseDTO findCarById(Long id){
       Car car = crepo.findById(id).orElseThrow(()-> new CarNotFoundException(id));
       return mapper.toEntity(car);
    }

    public List<Car> findAllAvailableCars(){
        return crepo.findByIsRented(false);
    }

    // POST
    public ResponseEntity<?> addCar(CarRequestDTO carDTO){
        crepo.save(mapper.toEntity(carDTO));
        return ResponseEntity.ok(carDTO);
    }
    // DELETE
    public ResponseEntity<?> deleteCar(Long id){
        Car car = crepo.findById(id).orElse(null);
        if(car == null){
            return ResponseEntity.notFound().build();
        }
        crepo.delete(car);
        return ResponseEntity.ok().build();
    }

}
