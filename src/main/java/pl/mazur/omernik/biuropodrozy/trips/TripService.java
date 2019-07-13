package pl.mazur.omernik.biuropodrozy.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripsRepository<Trips> tripsRepository;

    @Autowired
    private TripsToProductDTOBuilder tripsToProductDTOBuilder;

    public void createNewProduct(String tripDestination, String continent, String country
                               , String airport, String hotel, LocalDate timeOfDeparture
                               , LocalDate timeOfArrival, int numberOfDays) {
        Trips trips = new Trips();
        trips.setTripDestination(tripDestination);
        trips.setContinent(continent);
        trips.setCountry(country);
        trips.setAirport(airport);
        trips.setHotel(hotel);
        trips.setTimeOfDeparture(timeOfDeparture);
        trips.setTimeOfArrival(timeOfArrival);
        trips.setNumberOfDays(numberOfDays);

        tripsRepository.save(trips);
    }

    public void updateTrips(TripsDTO productDTO){
        Trips s = tripsToProductDTOBuilder.buildEntity(productDTO);
        tripsRepository.save(s);
    }

    public Optional<Trips> findProducts(Long id){
        return tripsRepository.findProductById(id);
    }

    public List<Trips> findTripsToEdit(String query, String destination) {
        return findTripsToEdit(query,destination);
    }

    @PostConstruct
    private void mockTrips() {
        createNewProduct("Majorka", "Europe", "Spain"
                , "Malorka Airport", "jakis tam"
                , LocalDate.of(2019, 06, 04)
                , LocalDate.of(2019, 06, 04)
                , 5);
    }

}
