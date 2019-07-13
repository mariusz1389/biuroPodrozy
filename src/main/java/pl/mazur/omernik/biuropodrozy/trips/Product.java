package pl.mazur.omernik.biuropodrozy.trips;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mazur.omernik.biuropodrozy.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Product extends BaseEntity {

    private String tripDestination;
    private String continent;
    private String country;
    private String airport;
    private String hotel;
    private LocalDate timeOfDeparture;
    private LocalDate timeOfArrival;
    private int numberOfDays;





}
