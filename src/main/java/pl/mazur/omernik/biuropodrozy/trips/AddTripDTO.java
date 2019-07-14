package pl.mazur.omernik.biuropodrozy.trips;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
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
    @Pattern(regexp = "^(19|20)[0-9]{2}-(0[1-9]|1[0-2])-(0[1-9]|(1|2)[0-9]|3[0-1])$", message = "Zły format. Data wylotu powinna być podana w formacie RRRR-MM-DD")
    private LocalDate timeOfDeparture;
    @Pattern(regexp = "^(19|20)[0-9]{2}-(0[1-9]|1[0-2])-(0[1-9]|(1|2)[0-9]|3[0-1])$", message = "Zły format. Data przylotu powinna być podana w formacie RRRR-MM-DD")
    private LocalDate timeOfArrival;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private Integer numberOfDays;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private Integer price;
}
