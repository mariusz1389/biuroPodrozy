package pl.mazur.omernik.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.trips.AddTripDTO;
import pl.mazur.omernik.biuropodrozy.trips.TripService;
import pl.mazur.omernik.biuropodrozy.trips.Trip;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TripService tripService;

    List<Trip> trip = new ArrayList<>();

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

    @GetMapping(value = "/addTrip")
    public String administrateTrips(Model model) {
        model.addAttribute("addNewTrip", new AddTripDTO());
        return "Admin";
    }

    @PostMapping(value = "/addTrip")
    public String addTripEffect(@ModelAttribute(name = "addNewTrip")
                                    @Valid AddTripDTO addNewTripDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "Admin";
        }
        tripService.addNewTrips(addNewTripDTO);
        return "addTripEffect";
    }


    public void initTrip() {

        trip = tripService.findAllTrips();

    }


}


