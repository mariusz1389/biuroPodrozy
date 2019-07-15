package pl.mazur.omernik.biuropodrozy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.mazur.omernik.biuropodrozy.Entity.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Addres extends BaseEntity {

//    Country country;
    String streat;
    String zipCode;
    String houseNumber;



    @Override
    public String toString() {
        return "Addres{" +
                "streat='" + streat + '\'' +
                ", zipCode='" + zipCode + '\'' +

                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
