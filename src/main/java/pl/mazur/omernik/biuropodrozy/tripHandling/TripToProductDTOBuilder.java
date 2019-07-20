package pl.mazur.omernik.biuropodrozy.tripHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.model.Trip;
import pl.mazur.omernik.biuropodrozy.reposityory.*;

@Service
public class TripToProductDTOBuilder {

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private TripRepository<Trip> tripRepository;

    public TripDTO buildDto(Trip trip) {
        return TripDTO.builder()
                .id(trip.getId())
                .tripDestination(trip.getTripDestination())
//                .continenId(Optional.ofNullable(tripHandling.getContinent()).map(e -> e.getId()).orElse(null))
//                .countryId(Optional.ofNullable(tripHandling.getContinent()).map(e -> e.getId()).orElse(null))
//                .airportId(Optional.ofNullable(tripHandling.getContinent()).map(e -> e.getId()).orElse(null))
//                .hotelId(Optional.ofNullable(tripHandling.getContinent()).map(e -> e.getId()).orElse(null))
                .timeOfDeparture(trip.getTimeOfDeparture())
                .timeOfArrival(trip.getTimeOfArrival())
                .numberOfDays(trip.getNumberOfDays())
                .build();
    }//buildDto

    public Trip buildEntity(TripDTO dto) {
        Trip trip;
        if (dto.getId() == null) {
            trip = new Trip();
        } else {
            trip = tripRepository.getOne(dto.getId());
        }

        trip.setTripDestination(dto.getTripDestination());
//        tripHandling.setContinent(Optional.ofNullable(dto.getContinenId())
//                .map(continentRepository::getOne).orElse(null));
//        tripHandling.setCountry(Optional.ofNullable(dto.getCountryId())
//                .map(countryRepository::getOne).orElse(null));
//        tripHandling.setAirport(Optional.ofNullable(dto.getAirportId())
//                .map(airportRepository::getOne).orElse(null));
//        tripHandling.setHotel(Optional.ofNullable(dto.getHotelId())
//                .map(hotelRepository::getOne).orElse(null));
        trip.setTimeOfDeparture(dto.getTimeOfDeparture());
        trip.setTimeOfArrival(dto.getTimeOfArrival());
        trip.setNumberOfDays(dto.getNumberOfDays());
        return trip;
    }

}
