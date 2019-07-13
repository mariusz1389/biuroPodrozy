package pl.mazur.omernik.biuropodrozy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import pl.mazur.omernik.biuropodrozy.entity.Airport;
import pl.mazur.omernik.biuropodrozy.entity.City;
import pl.mazur.omernik.biuropodrozy.entity.Hotel;
import pl.mazur.omernik.biuropodrozy.entity.Trip;
import pl.mazur.omernik.biuropodrozy.reposityory.TripRepo;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class TripApi {

    private TripRepo tripRepo;

    @Autowired
    public TripApi(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    @GetMapping
    public Iterable<Trip> getTrips() {
        return tripRepo.findAll();
    }

    @PostMapping
    public void addTrip(@RequestBody Trip trip) {
        tripRepo.save(trip);
    }

    @DeleteMapping
    public void removeTrip(@RequestParam Long id) {
        tripRepo.deleteById(id);
    }

    @PutMapping
    public void putTrip(@RequestBody Trip trip) {
        Optional<Trip> element = tripRepo.findById(trip.getId());
        if (element.isPresent()) {
            tripRepo.save(trip);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {

        Trip trip1 = new Trip("Berlin", "Tegel", "HotelRobotniczy"
                , LocalDate.of(2019, 01, 01)
                , LocalDate.of(2019, 01, 02)
                , 2);


        tripRepo.save(trip1);

    }
}
