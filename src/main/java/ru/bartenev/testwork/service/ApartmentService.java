package ru.bartenev.testwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bartenev.testwork.dto.ApartmentDTO;
import ru.bartenev.testwork.entity.Apartment;
import ru.bartenev.testwork.exception.ApartmentNotFoundException;
import ru.bartenev.testwork.exception.BuildingNotFoundException;
import ru.bartenev.testwork.mapper.ApartmentMapper;
import ru.bartenev.testwork.repository.ApartmentRepository;
import ru.bartenev.testwork.repository.BuildingRepository;

import java.util.List;

@Service
public class ApartmentService {
    private ApartmentRepository apartmentRepository;
    private BuildingRepository buildingRepository;
    private ApartmentMapper apartmentMapper;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository, BuildingRepository buildingRepository, ApartmentMapper apartmentMapper) {
        this.apartmentRepository = apartmentRepository;
        this.buildingRepository = buildingRepository;
        this.apartmentMapper = apartmentMapper;
    }

    public Apartment getApartment(Long apartmentId) {
        return apartmentRepository.findByApartmentId(apartmentId).orElseThrow(() -> new ApartmentNotFoundException("Apartment with apartmentId: " + apartmentId + " not found."));
    }

    public List<Apartment> getApartments() {
        return apartmentRepository.findAll();
    }

    public List<Apartment> getApartmentsByBuildingId(Long buildingId) {
        checkBuildingExists(buildingId);
        return apartmentRepository.findByBuilding_BuildingId(buildingId);
    }


    public Apartment createApartment(Apartment apartment) {
        checkBuildingExists(apartment.getBuilding().getBuildingId());
        return apartmentRepository.save(apartment);
    }

    public Apartment updateApartment(ApartmentDTO apartmentDTO) {
        Apartment apartment = getApartment(apartmentDTO.getApartmentId());
        apartmentMapper.updateApartmentFromDTO(apartmentDTO, apartment);
        return apartmentRepository.save(apartment);
    }

    public Apartment deleteApartment(Long apartmentId) {
        Apartment apartment = getApartment(apartmentId);
        apartmentRepository.deleteById(apartmentId);
        return apartment;
    }

    public void checkBuildingExists(Long buildingId) {
        if (!buildingRepository.existsByBuildingId(buildingId)) {
            throw new BuildingNotFoundException("Building with buildingId: " + buildingId + " not found.");
        }
    }

}
