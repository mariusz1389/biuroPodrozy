package pl.mazur.omernik.biuropodrozy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mazur.omernik.biuropodrozy.BaseEntity;

import javax.persistence.Entity;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Trip extends BaseEntity {

    private String city;
    private String airport;
    private String hotel;
    private LocalDate dateDeparture;
    private LocalDate dateArrival;
    private int numberOfDays;


    public void destinationTo(String city, String airport, String hotel) {
    }

}

