package edu.hyf.car_rental.controller;


import edu.hyf.car_rental.dto.RentalRequestDTO;
import edu.hyf.car_rental.dto.RentalResponseDTO;
import edu.hyf.car_rental.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rental")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @GetMapping
    public ResponseEntity<Object> findAllRentals() {
        return ResponseEntity.ok(rentalService.findAllRentals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalResponseDTO> findRentalById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.findRentalById(id));
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<RentalResponseDTO>> getOverdueRentals() {
        return ResponseEntity.ok(rentalService.getOverdueRentals());
    }

    @PostMapping("/add")
    public ResponseEntity<RentalResponseDTO> addRental(@Valid @RequestBody RentalRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalService.addRental(dto));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<RentalResponseDTO> activateRental(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.activateRental(id));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<RentalResponseDTO> completeRental(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.completeRental(id));
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<RentalResponseDTO> cancelRental(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.cancelRental(id));
    }
}
