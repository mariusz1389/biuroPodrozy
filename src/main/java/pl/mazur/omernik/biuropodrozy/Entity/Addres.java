package pl.mazur.omernik.biuropodrozy.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Addres {

    String streat;
    String zipCode;
    String Country;
    String houseNumber;

    public Addres(String streat, String zipCode, String country, String houseNumber) {
        this.streat = streat;
        this.zipCode = zipCode;
        Country = country;
        this.houseNumber = houseNumber;
    }

    public Addres(){

    }

    @Override
    public String toString() {
        return "Addres{" +
                "streat='" + streat + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", Country='" + Country + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
