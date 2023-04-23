package ru.bartenev.testwork.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bartenev.testwork.dto.ApartmentDTO;
import ru.bartenev.testwork.entity.Apartment;
import ru.bartenev.testwork.mapper.ApartmentMapper;
import ru.bartenev.testwork.service.ApartmentService;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/buildings")
public class ApartmentController {
    private ApartmentService apartmentService;
    private ApartmentMapper apartmentMapper;

    @Autowired
    public ApartmentController(ApartmentService apartmentService, ApartmentMapper apartmentMapper) {
        this.apartmentService = apartmentService;
        this.apartmentMapper = apartmentMapper;
    }


    @GetMapping("/apartments")
    @ResponseBody
    public List<ApartmentDTO> getApartments() {
        return apartmentMapper.apartmentsToDto(apartmentService.getApartments());
    }

    @GetMapping(value = "/{buildingId}/apartments")
    @ResponseBody
    public List<ApartmentDTO> getApartments(@PathVariable(value = "buildingId") Long buildingId) {
        return apartmentMapper.apartmentsToDto(apartmentService.getApartmentsByBuildingId(buildingId));
    }


    @PostMapping(value = "/{buildingId}/apartments")
    @ResponseBody
    public ApartmentDTO createApartment(@PathVariable(value = "buildingId") Long buildingId, @Valid @RequestBody ApartmentDTO apartmentDTO) {
        apartmentDTO.setBuildingId(buildingId);
        Apartment apartment = apartmentService.createApartment(apartmentMapper.dtoToApartment(apartmentDTO));
        return apartmentMapper.apartmentToDto(apartment);
    }

    @GetMapping(value = "/apartments/{apartmentId}")
    @ResponseBody
    public ApartmentDTO getApartment(@PathVariable(value = "apartmentId") Long apartmentId) {
        return apartmentMapper.apartmentToDto(apartmentService.getApartment(apartmentId));
    }

    @PutMapping(value = "/apartments/{apartmentId}")
    @ResponseBody
    public ApartmentDTO updateBuilding(@PathVariable(value = "apartmentId") Long apartmentId, @RequestBody ApartmentDTO apartmentDTO) {
        apartmentDTO.setApartmentId(apartmentId);
        return apartmentMapper.apartmentToDto(apartmentService.updateApartment(apartmentDTO));
    }

    @DeleteMapping(value = "/apartments/{apartmentId}")
    @ResponseBody
    public ApartmentDTO deleteBuilding(@PathVariable(value = "apartmentId") Long apartmentId) {
        return apartmentMapper.apartmentToDto(apartmentService.deleteApartment(apartmentId));
    }


}
