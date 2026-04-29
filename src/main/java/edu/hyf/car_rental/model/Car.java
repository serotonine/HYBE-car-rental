package edu.hyf.car_rental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="car")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String brand;

    @NotNull
    @Column(nullable = false, unique = true)
    private String plate;

    @NotNull
    @Column(nullable = false)
    private int year;

    private String color;

    private String model;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarStatus status = CarStatus.AVAILABLE;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentalRecord = new ArrayList<>();

    public void addRental(Rental rental) {
        rentalRecord.add(rental);
        rental.setCar(this);
    }

    public void removeRental(Rental rental) {
        rentalRecord.remove(rental);
        rental.setCar(null);
    }
}
