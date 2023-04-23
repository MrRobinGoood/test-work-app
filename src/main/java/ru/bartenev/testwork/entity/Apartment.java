package ru.bartenev.testwork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "apartment")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;
}
