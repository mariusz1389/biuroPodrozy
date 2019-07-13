package pl.mazur.omernik.biuropodrozy.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.reposityory.AirportRepository;
import pl.mazur.omernik.biuropodrozy.reposityory.ContinentRepository;
import pl.mazur.omernik.biuropodrozy.reposityory.CountryRepository;
import pl.mazur.omernik.biuropodrozy.reposityory.HotelRepository;

@Service
public class TripsToProductDTOBuilder {

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private TripsRepository<Trips> tripsRepository;

    public TripsDTO buildDto(Trips trips) {
        return TripsDTO.builder()
                .id(trips.getId())
                .tripDestination(trips.getTripDestination())
//                .continenId(Optional.ofNullable(trips.getContinent()).map(e -> e.getId()).orElse(null))
//                .countryId(Optional.ofNullable(trips.getContinent()).map(e -> e.getId()).orElse(null))
//                .airportId(Optional.ofNullable(trips.getContinent()).map(e -> e.getId()).orElse(null))
//                .hotelId(Optional.ofNullable(trips.getContinent()).map(e -> e.getId()).orElse(null))
                .timeOfDeparture(trips.getTimeOfDeparture())
                .timeOfArrival(trips.getTimeOfArrival())
                .numberOfDays(trips.getNumberOfDays())
                .build();
    }//buildDto

    public Trips buildEntity(TripsDTO dto) {
        Trips trips;
        if (dto.getId() == null) {
            trips = new Trips();
        } else {
            trips = tripsRepository.getOne(dto.getId());
        }

        trips.setTripDestination(dto.getTripDestination());
//        trips.setContinent(Optional.ofNullable(dto.getContinenId())
//                .map(continentRepository::getOne).orElse(null));
//        trips.setCountry(Optional.ofNullable(dto.getCountryId())
//                .map(countryRepository::getOne).orElse(null));
//        trips.setAirport(Optional.ofNullable(dto.getAirportId())
//                .map(airportRepository::getOne).orElse(null));
//        trips.setHotel(Optional.ofNullable(dto.getHotelId())
//                .map(hotelRepository::getOne).orElse(null));
        trips.setTimeOfDeparture(dto.getTimeOfDeparture());
        trips.setTimeOfArrival(dto.getTimeOfArrival());
        trips.setNumberOfDays(dto.getNumberOfDays());
        return trips;
    }

}
