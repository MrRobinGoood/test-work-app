package ru.bartenev.testwork.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ApartmentDTO {

    private Long buildingId;

    private Long apartmentId;
    @NotNull
    private Double area;
    @NotNull
    private Integer countRooms;
    @NotNull
    private Integer apartmentFloor;
    private String renovation;
    @NotNull
    private Integer price;

}
