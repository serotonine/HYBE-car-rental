package edu.hyf.car_rental.mapper;

import edu.hyf.car_rental.dto.CarRequestDTO;
import edu.hyf.car_rental.dto.CarResponseDTO;
import edu.hyf.car_rental.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface CarMapper {
    @Mapping(source = "rental.id", target = "rentalId")
    CarResponseDTO toResponseDTO(Car car);
    @Mapping(target = "id", ignore = true)
    Car toEntity(CarRequestDTO dto);

}