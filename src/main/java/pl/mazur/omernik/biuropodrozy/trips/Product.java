package pl.mazur.omernik.biuropodrozy.trips;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mazur.omernik.biuropodrozy.BaseEntity;
import pl.mazur.omernik.biuropodrozy.entity.Airport;
import pl.mazur.omernik.biuropodrozy.entity.Continent;
import pl.mazur.omernik.biuropodrozy.entity.Country;
import pl.mazur.omernik.biuropodrozy.entity.Hotel;


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
    private Continent continent;
    private Country country;
    private Airport airport;
    private Hotel hotel;
    private LocalDate timeOfDeparture;
    private LocalDate timeOfArrival;
    private int numberOfDays;





}
