package ru.bartenev.testwork.mapper;

import org.mapstruct.*;
import ru.bartenev.testwork.dto.ApartmentDTO;
import ru.bartenev.testwork.entity.Apartment;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ApartmentMapper {
    @Mapping(source = "building.buildingId", target = "buildingId")
    ApartmentDTO apartmentToDto(Apartment apartment);

    @Mapping(source = "buildingId", target = "building.buildingId")
    Apartment dtoToApartment(ApartmentDTO apartmentDTO);

    List<ApartmentDTO> apartmentsToDto(List<Apartment> apartments);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateApartmentFromDTO(ApartmentDTO apartmentDTO, @MappingTarget Apartment apartment);

}
