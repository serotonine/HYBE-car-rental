package edu.hyf.car_rental.mapper;

import edu.hyf.car_rental.dto.RentalRequestDTO;
import edu.hyf.car_rental.dto.RentalResponseDTO;
import edu.hyf.car_rental.model.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface RentalMapper {
    RentalResponseDTO toResponseDTO(Rental rental);
   // @Mapping(target = "id", ignore = true)
    Rental toEntity (RentalRequestDTO dto);
}
