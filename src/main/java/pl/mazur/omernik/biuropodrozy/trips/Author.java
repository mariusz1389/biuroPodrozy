package pl.mazur.omernik.biuropodrozy.trips;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mazur.omernik.biuropodrozy.BaseEntity;


import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Author extends BaseEntity {
    private String firstName;
    private String surname;

    public Author(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getFullAuthorName() {
        return firstName + " " + surname;
    }

}
