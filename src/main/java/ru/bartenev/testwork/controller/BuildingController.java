package ru.bartenev.testwork.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bartenev.testwork.dto.BuildingDTO;
import ru.bartenev.testwork.entity.Building;
import ru.bartenev.testwork.mapper.BuildingMapper;
import ru.bartenev.testwork.service.BuildingService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/buildings")
public class BuildingController {
    private BuildingService buildingService;
    private BuildingMapper buildingMapper;

    @Autowired
    public BuildingController(BuildingService buildingService, BuildingMapper buildingMapper) {
        this.buildingService = buildingService;
        this.buildingMapper = buildingMapper;
    }

    @GetMapping(value = "/{buildingId}")
    @ResponseBody
    public BuildingDTO getBuilding(@PathVariable(value = "buildingId") Long buildingId) {
        return buildingMapper.buildingToDto(buildingService.getBuilding(buildingId));
    }

    @GetMapping
    @ResponseBody
    public List<BuildingDTO> getBuildings() {
        return buildingMapper.buildingsToDto(buildingService.getBuildings());
    }

    @PostMapping
    @ResponseBody
    public BuildingDTO createBuilding(@Valid @RequestBody BuildingDTO buildingDTO) {
        Building building = buildingMapper.dtoToBuilding(buildingDTO);
        return buildingMapper.buildingToDto(buildingService.createBuilding(building));
    }

    @PutMapping(value = "/{buildingId}")
    @ResponseBody
    public BuildingDTO updateBuilding(@PathVariable(value = "buildingId") Long buildingId, @RequestBody BuildingDTO buildingDTO) {
        buildingDTO.setBuildingId(buildingId);
        return buildingMapper.buildingToDto(buildingService.updateBuilding(buildingDTO));
    }

    @DeleteMapping(value = "/{buildingId}")
    @ResponseBody
    public BuildingDTO deleteBuilding(@PathVariable(value = "buildingId") Long buildingId) {
        return buildingMapper.buildingToDto(buildingService.deleteBuilding(buildingId));
    }
}
