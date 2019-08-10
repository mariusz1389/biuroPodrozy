package pl.mazur.omernik.biuropodrozy.tripHandling;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@DiscriminatorValue(value = "N")
public class NonPromotionTrip extends Trip {
}
