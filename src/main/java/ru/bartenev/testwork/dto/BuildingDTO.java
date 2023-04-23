package ru.bartenev.testwork.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDate;

@Data
public class BuildingDTO {

    private Long buildingId;
    @NotNull
    private String address;
    @NotNull
    private LocalDate dateConstructed;
    @NotNull
    private Integer countFloors;
    @NotNull
    private Integer countEntrances;
    @NotNull
    private Boolean parking;
}
