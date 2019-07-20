package pl.mazur.omernik.biuropodrozy.model;

import lombok.*;
import pl.mazur.omernik.biuropodrozy.Entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Trip extends BaseEntity {

    private Integer stockAmount;
    private String tripDestination;
    private String continent;
    private String country;
    private String airport;
    private String hotel;
    private LocalDate timeOfDeparture;
    private LocalDate timeOfArrival;
    private Integer numberOfDays;
    private BigDecimal price;



}
