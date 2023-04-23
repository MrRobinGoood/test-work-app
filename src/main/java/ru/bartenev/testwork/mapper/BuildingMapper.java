package ru.bartenev.testwork.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.bartenev.testwork.dto.BuildingDTO;
import ru.bartenev.testwork.entity.Building;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    BuildingDTO buildingToDto(Building building);

    Building dtoToBuilding(BuildingDTO buildingDTO);

    List<BuildingDTO> buildingsToDto(List<Building> buildings);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBuildingFromDTO(BuildingDTO buildingDTO, @MappingTarget Building building);
}
