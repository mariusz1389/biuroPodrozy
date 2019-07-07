package pl.mazur.omernik.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.api.TripRepo;
import pl.mazur.omernik.biuropodrozy.entity.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class MainController {


    Set<Trip> trip = new HashSet<>();
    public String someText = "Nowa Wycieczka!";

    @GetMapping("/trip")
    public ModelAndView getMain() {
        ModelAndView m = new ModelAndView("index");
        m.setViewName("index");
        m.addObject("someText", someText);
        initTrip();
        m.addObject("trips", trip);
        return m;
    }

    public void initTrip() {
        for (int i = 0; i <= 10; i++) {
            trip.add( new Trip(new City("Londyn1")
                    , new Airport("Chopina1")
                    , new Hotel("Hilton1", 5)
                    , LocalDate.of(2019, 01, 01)
                    , LocalDate.of(2019, 01, 02)
                    , 2));

        }
    }

    private TripRepo tripRepo;

    @Autowired
    public MainController(TripRepo tripRepo) {
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

        Trip trip1 = new Trip(new City("Londyn")
                , new Airport("Chopina")
                , new Hotel("Hilton", 5)
                , LocalDate.of(2019, 01, 01)
                , LocalDate.of(2019, 01, 02)
                , 2);


        tripRepo.save(trip1);

    }
}