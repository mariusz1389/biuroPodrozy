package pl.mazur.omernik.biuropodrozy.trips;

import lombok.*;
import pl.mazur.omernik.biuropodrozy.BaseEntity;
import pl.mazur.omernik.biuropodrozy.entity.Trip;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Trips extends BaseEntity {

    private String tripDestination;
    private String continent;
    private String country;
    private String airport;
    private String hotel;
    private LocalDate timeOfDeparture;
    private LocalDate timeOfArrival;
    private Integer numberOfDays;

//    private Trip trip;

}
