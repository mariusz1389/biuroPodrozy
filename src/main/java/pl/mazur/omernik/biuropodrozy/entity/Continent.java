package pl.mazur.omernik.biuropodrozy.entity;

import lombok.*;
import pl.mazur.omernik.biuropodrozy.Entity.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Continent extends BaseEntity {

    private String ciontinentName;
}
