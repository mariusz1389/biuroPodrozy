package pl.mazur.omernik.biuropodrozy.trips;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String tripDestination;
    private Long continenIdt;
    private Long countryId;
    private Long airportId;
    private Long hotelId;
    private LocalDate timeOfDeparture;
    private LocalDate timeOfArrival;
    private int numberOfDays;
}
