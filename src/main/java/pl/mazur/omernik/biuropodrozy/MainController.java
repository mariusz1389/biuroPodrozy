package pl.mazur.omernik.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.trips.TripService;
import pl.mazur.omernik.biuropodrozy.trips.Trips;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TripService tripService;
    List<Trips> trip = new ArrayList<>();
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

        trip = tripService.findAllTrips();

    }
}


