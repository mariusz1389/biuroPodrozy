package pl.mazur.omernik.biuropodrozy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.mazur.omernik.biuropodrozy.BaseEntity;

import javax.persistence.Entity;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Airport extends BaseEntity {
//    Addres addres;
    private String airportName;
}
