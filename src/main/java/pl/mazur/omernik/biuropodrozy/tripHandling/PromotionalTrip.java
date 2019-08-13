package pl.mazur.omernik.biuropodrozy.tripHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@AllArgsConstructor
@DiscriminatorValue(value = "P")
public class PromotionalTrip extends Trip {
}
