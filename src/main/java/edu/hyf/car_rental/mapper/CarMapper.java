package edu.hyf.car_rental.mapper;

import edu.hyf.car_rental.dto.CarRequestDTO;
import edu.hyf.car_rental.dto.CarResponseDTO;
import edu.hyf.car_rental.dto.CarUpdateRequestDTO;
import edu.hyf.car_rental.model.Car;
import org.mapstruct.*;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {
    // @Mapping(source = "car.rental.id", target = "rentalId")
    CarResponseDTO toResponseDTO(Car car);
    // @Mapping(target = "id", ignore = true)
    Car toEntity(CarRequestDTO dto);
    // Used in car_rental.service.updateCar()
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDTO(CarUpdateRequestDTO dto, @MappingTarget Car car);
}
