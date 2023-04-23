package ru.bartenev.testwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bartenev.testwork.entity.Building;

import java.util.Optional;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    Optional<Building> findByBuildingId(Long buildingId);

    Boolean existsByBuildingId(Long buildingId);

}
