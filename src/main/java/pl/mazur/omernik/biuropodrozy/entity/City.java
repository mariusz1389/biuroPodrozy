package pl.mazur.omernik.biuropodrozy.entity;

import lombok.*;
import pl.mazur.omernik.biuropodrozy.BaseEntity;

import javax.persistence.Entity;



@Getter
@Setter
@AllArgsConstructor
@Entity
@ToString
public class City extends BaseEntity {

    private String cityName;


}
