package pl.mazur.omernik.biuropodrozy.trips;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class AddTripDTO {

    @NotBlank(message = "Pole musi zostać wypełnione")
    private String tripDestination;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String continent;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String country;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String airport;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String hotel;
    @NotNull(message = "Pole musi zostać wypełnione")
    private String timeOfDeparture;
    @NotNull(message = "Pole musi zostać wypełnione")
    private String timeOfArrival;
    @NotNull(message = "Pole musi zostać wypełnione")
    private Integer numberOfDays;
    @NotNull(message = "Pole musi zostać wypełnione")
    private Integer price;
}
