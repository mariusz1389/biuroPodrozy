package pl.mazur.omernik.biuropodrozy.tripHandling;

import lombok.*;
import pl.mazur.omernik.biuropodrozy.entity.BaseEntity;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="system_type",
        discriminatorType = DiscriminatorType.STRING)
public class Trip extends BaseEntity {

    private Integer stockAmount;
    private String tripDestination;
    private String continent;
    private String country;
    private String airport;
    private String hotel;
    private String pictureUrl;
    private LocalDate timeOfDeparture;
    private LocalDate timeOfArrival;
    private Integer numberOfDays;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private TripType tripType;



}
