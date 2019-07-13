package pl.mazur.omernik.biuropodrozy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.entity.Trip;
import pl.mazur.omernik.biuropodrozy.trips.Trips;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {



    Set<Trips> trip = new HashSet<>();
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

        }
    }


}