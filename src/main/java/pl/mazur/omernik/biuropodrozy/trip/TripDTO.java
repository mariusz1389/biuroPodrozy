package pl.mazur.omernik.biuropodrozy.trip;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TripDTO {

    private Long id;
    private String tripDestination;
    private Long continenId;
    private Long countryId;
    private Long airportId;
    private Long hotelId;
    private LocalDate timeOfDeparture;
    private LocalDate timeOfArrival;
    private Integer numberOfDays;
    private Integer price;
}
