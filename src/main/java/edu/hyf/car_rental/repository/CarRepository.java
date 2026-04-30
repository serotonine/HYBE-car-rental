package edu.hyf.car_rental.repository;


import edu.hyf.car_rental.model.Car;
import edu.hyf.car_rental.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface CarRepository extends JpaRepository <Car, Long>{
    boolean existsById(Long id);
    Optional<Car>findById(Long id);
    List<Car> findByStatus(CarStatus status);
}
