package ru.bartenev.testwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bartenev.testwork.dto.BuildingDTO;
import ru.bartenev.testwork.entity.Building;
import ru.bartenev.testwork.exception.BuildingNotFoundException;
import ru.bartenev.testwork.mapper.BuildingMapper;
import ru.bartenev.testwork.repository.BuildingRepository;

import java.util.List;

@Service
public class BuildingService {
    private BuildingRepository buildingRepository;
    private BuildingMapper buildingMapper;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository, BuildingMapper buildingMapper) {
        this.buildingRepository = buildingRepository;
        this.buildingMapper = buildingMapper;
    }

    public List<Building> getBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuilding(Long buildingId) {
        return buildingRepository.findByBuildingId(buildingId).orElseThrow(() -> new BuildingNotFoundException("Building with buildingId: " + buildingId + " not found."));
    }

    public Building createBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public Building updateBuilding(BuildingDTO buildingDTO) {
        Building building = getBuilding(buildingDTO.getBuildingId());
        buildingMapper.updateBuildingFromDTO(buildingDTO, building);
        return buildingRepository.save(building);
    }

    public Building deleteBuilding(Long buildingId) {
        Building building = getBuilding(buildingId);
        buildingRepository.deleteById(buildingId);
        return building;
    }
}
