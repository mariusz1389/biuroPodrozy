package pl.mazur.omernik.biuropodrozy.entity;

import lombok.*;
import pl.mazur.omernik.biuropodrozy.BaseEntity;

import javax.persistence.Entity;

@ToString
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Country extends BaseEntity {
    private String countryName;
}
