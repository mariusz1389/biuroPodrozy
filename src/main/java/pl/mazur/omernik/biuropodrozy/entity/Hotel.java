package pl.mazur.omernik.biuropodrozy.entity;

import lombok.*;
import pl.mazur.omernik.biuropodrozy.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Hotel extends BaseEntity {

    private String hotelName;
    private int stars;
//    Addres addres;

}
