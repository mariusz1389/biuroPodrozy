package pl.mazur.omernik.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.reposityory.TripRepo;
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


}