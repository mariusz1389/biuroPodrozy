package pl.mazur.omernik.biuropodrozy.entity;

import lombok.*;
import pl.mazur.omernik.biuropodrozy.BaseEntity;

import javax.persistence.Entity;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class Airport extends BaseEntity {
//    Addres addres;
    private String airportName;
}
