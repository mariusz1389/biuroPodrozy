package pl.mazur.omernik.biuropodrozy.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CustomerRegistrationDto {

    @NotBlank(message = "Pole musi zostać wypełnione")
    private String username;
    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]{2,}$", message = "Wymagane przynajmniej 3 znaki(pierwsza litera duża, reszta małe).")
    private String firstName;
    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]{2,}(-[\\p{Lu}][\\p{Ll}]{2,})?$", message = "Wymagane przynajmniej 3 znaki(pierwsza litera duża, można podać także nazwisko dwuczłonowe).")
    private String lastName;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*", message = "Hasło jest wymagane. Musi zawierać od 10 do 20 znaków, jedną duża, jedna małą literę i cyfrę.")
    private String password;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String street;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String city;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String zipCode;


}
