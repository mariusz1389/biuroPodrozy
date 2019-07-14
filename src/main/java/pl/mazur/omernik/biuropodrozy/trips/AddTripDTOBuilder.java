package pl.mazur.omernik.biuropodrozy.trips;

public class AddTripDTOBuilder {

    public static Trip rewriteToTrip(AddTripDTO dto) {
        Trip trip = new Trip();
        trip.setTripDestination(dto.getTripDestination().trim());
        trip.setContinent(dto.getContinent().trim());
        trip.setCountry(dto.getCountry().trim());
        trip.setAirport(dto.getAirport().trim());
        trip.setHotel(dto.getHotel().trim());
        trip.setTimeOfDeparture(dto.getTimeOfDeparture());
        trip.setTimeOfArrival(dto.getTimeOfArrival());
        trip.setNumberOfDays(dto.getNumberOfDays());
        trip.setPrice(dto.getPrice());
        return trip;
    }
}
