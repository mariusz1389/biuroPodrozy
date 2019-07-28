package pl.mazur.omernik.biuropodrozy.entity;

import lombok.*;

import javax.persistence.Entity;



@Getter
@Setter
@AllArgsConstructor
@Entity
@ToString
public class City extends BaseEntity {

    private String cityName;


}
