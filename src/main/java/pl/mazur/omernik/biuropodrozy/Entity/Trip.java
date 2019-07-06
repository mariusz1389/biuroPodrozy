package pl.mazur.omernik.biuropodrozy.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Trip {

    public String city;
    public String airport;
    public String hotel;
    public String dateDeparture;
    public String dateArrival;
    public int numberOfDays;

    public Trip(String city, String airport, String hotel, String dateDeparture, String dateArrival, int numberOfDays) {
        this.city = city;
        this.airport = airport;
        this.hotel = hotel;
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
        this.numberOfDays = numberOfDays;
    }

    public void dstinationTo(String city, String airport, String hotel) {


    }


    public void destinationFrom(String szczecin, String goleniow_nie_w_szc) {
    }

    @Override
    public String toString() {
        return "Trip{" +
                "city='" + city + '\'' +
                ", airport='" + airport + '\'' +
                ", hotel='" + hotel + '\'' +
                ", dateDeparture='" + dateDeparture + '\'' +
                ", dateArrival='" + dateArrival + '\'' +
                ", numberOfDays=" + numberOfDays +
                '}';
    }
}
