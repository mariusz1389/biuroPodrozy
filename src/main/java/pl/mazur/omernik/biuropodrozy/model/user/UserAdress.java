package pl.mazur.omernik.biuropodrozy.model.user;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class UserAdress {

    private String street;
    private String city;
    private String country;
    private String zipCode;

}
