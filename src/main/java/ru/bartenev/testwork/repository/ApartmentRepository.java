package ru.bartenev.testwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bartenev.testwork.entity.Apartment;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findByBuilding_BuildingId(Long buildingId);

    Optional<Apartment> findByApartmentId(Long apartmentId);

}
