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
    private TripRepository<Trip> tripRepository;

    @Autowired
    private TripToProductDTOBuilder tripToProductDTOBuilder;

    public void createNewProduct(String tripDestination, String continent, String country
            , String airport, String hotel, LocalDate timeOfDeparture
            , LocalDate timeOfArrival, int numberOfDays) {
        Trip trip = new Trip();
        trip.setTripDestination(tripDestination);
        trip.setContinent(continent);
        trip.setCountry(country);
        trip.setAirport(airport);
        trip.setHotel(hotel);
        trip.setTimeOfDeparture(timeOfDeparture);
        trip.setTimeOfArrival(timeOfArrival);
        trip.setNumberOfDays(numberOfDays);

        tripRepository.save(trip);
    }

    public void updateTrips(TripDTO productDTO) {
        Trip s = tripToProductDTOBuilder.buildEntity(productDTO);
        tripRepository.save(s);
    }

    public Optional<Trip> findProducts(Long id) {
        return tripRepository.findProductById(id);
    }

    public List<Trip> findTripsToEdit(String query, String destination) {
        return findTripsToEdit(query, destination);
    }


    public List<Trip> findAllTrips(){
        return tripRepository.findAll();
    }

    public void addNewTrips(AddTripDTO addTripDTO){
        Trip trip = AddTripDTOBuilder.rewriteToTrip(addTripDTO);
//        if(tripRepository.existByTripDestination(trip.getTripDestination())){
//            throw new TripExistsException("Trip with destination " + trip.getTripDestination() + "already exists in database");
//        } else {
            tripRepository.save(trip);
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
