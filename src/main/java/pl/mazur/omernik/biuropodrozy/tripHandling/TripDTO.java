package pl.mazur.omernik.biuropodrozy.tripHandling;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TripDTO {

    private Long id;
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
    private TripType tripType;

    public String getTripTypePl() {
        return Optional.ofNullable(tripType).map(e -> e.getType()).orElse("");
    }
}
