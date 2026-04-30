package edu.hyf.car_rental.service;

import edu.hyf.car_rental.dto.RentalRequestDTO;
import edu.hyf.car_rental.dto.RentalResponseDTO;
import edu.hyf.car_rental.mapper.RentalMapper;
import edu.hyf.car_rental.model.Car;
import edu.hyf.car_rental.model.CarStatus;
import edu.hyf.car_rental.model.Rental;
import edu.hyf.car_rental.repository.CarRepository;
import edu.hyf.car_rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepo;
    private final CarRepository carRepo;
    private final RentalMapper mapper;

    /* GET ALL RENTALS */

    public List<RentalResponseDTO> findAllRentals() {

        return rentalRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    /* GET RENTAL BY ID */

    public RentalResponseDTO findRentalById(Long id) {

        Rental rental = rentalRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Rental not found"));

        return mapper.toResponseDTO(rental);
    }

    /* GET OVERDUE RENTALS */

    public List<RentalResponseDTO> getOverdueRentals() {
            return rentalRepo.findOverdueRentals()
                    .stream()
                    .map(mapper::toResponseDTO)
                    .toList();
    }

    /* CREATE RENTAL */

    public RentalResponseDTO addRental(RentalRequestDTO dto) {

        Car car = carRepo.findById(dto.getRentalId())
                .orElseThrow(() ->
                        new RuntimeException("Car not found"));

<<<<<<< Updated upstream
        if (car.getStatus() == CarStatus.RENTED) {
=======
       /* if (car.getIsRented()) {
>>>>>>> Stashed changes
            throw new RuntimeException("Car already rented");
        }*/

        Rental rental = mapper.toEntity(dto);

        rental.setCar(car);

<<<<<<< Updated upstream
        car.setStatus(CarStatus.RENTED);
=======
       // car.setIsRented(true);
>>>>>>> Stashed changes

        Rental saved = rentalRepo.save(rental);

        return mapper.toResponseDTO(saved);
    }

    /* ACTIVATE RENTAL */

    public RentalResponseDTO activateRental(Long id) {

        Rental rental = rentalRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Rental not found"));

<<<<<<< Updated upstream
        rental.getCar().setStatus(CarStatus.RENTED);
=======
        // rental.getCar().setIsRented(true);
>>>>>>> Stashed changes

        Rental updated = rentalRepo.save(rental);

        return mapper.toResponseDTO(updated);
    }

    /* COMPLETE RENTAL */

    public RentalResponseDTO completeRental(Long id) {

        Rental rental = rentalRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Rental not found"));

<<<<<<< Updated upstream
        rental.getCar().setStatus(CarStatus.AVAILABLE);
=======
        // rental.getCar().setIsRented(false);
>>>>>>> Stashed changes

        Rental updated = rentalRepo.save(rental);

        return mapper.toResponseDTO(updated);
    }

    /* CANCEL RENTAL */

    public RentalResponseDTO cancelRental(Long id) {

        Rental rental = rentalRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Rental not found"));

<<<<<<< Updated upstream
        rental.getCar().setStatus(CarStatus.AVAILABLE);
=======
       // rental.getCar().setIsRented(false);
>>>>>>> Stashed changes

        rentalRepo.delete(rental);

        return mapper.toResponseDTO(rental);
    }
}
