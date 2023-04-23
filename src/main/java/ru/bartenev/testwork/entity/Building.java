package ru.bartenev.testwork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Table(name = "building")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private List<Apartment> apartments;

}
