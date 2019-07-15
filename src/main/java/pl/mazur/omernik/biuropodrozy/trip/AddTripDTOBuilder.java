package pl.mazur.omernik.biuropodrozy.trip;

import java.time.LocalDate;

public class AddTripDTOBuilder {

    public static Trip rewriteToTrip(AddTripDTO dto) {
        Trip trip = new Trip();
        trip.setTripDestination(dto.getTripDestination().trim());
        trip.setContinent(dto.getContinent().trim());
        trip.setCountry(dto.getCountry().trim());
        trip.setAirport(dto.getAirport().trim());
        trip.setHotel(dto.getHotel().trim());
        trip.setTimeOfDeparture(LocalDate.parse(dto.getTimeOfDeparture()));
        trip.setTimeOfArrival(LocalDate.parse(dto.getTimeOfArrival()));
        trip.setNumberOfDays(dto.getNumberOfDays());
        trip.setPrice(dto.getPrice());
        return trip;
    }
}
