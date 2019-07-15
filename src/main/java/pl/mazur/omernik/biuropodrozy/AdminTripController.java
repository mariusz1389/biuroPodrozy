package pl.mazur.omernik.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mazur.omernik.biuropodrozy.trip.AddTripDTO;
import pl.mazur.omernik.biuropodrozy.trip.TripService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin")
public class AdminTripController {


    @Autowired
    private TripService tripService;

    @GetMapping(value = "/addTrip")
    public String administrateTrips(Model model) {
        model.addAttribute("addNewTrip", new AddTripDTO());
        return "addTrip";
    }

    @PostMapping(value = "/addTrip")
    public String addTripEffect(@ModelAttribute(name = "addNewTrip")
                                @Valid AddTripDTO addNewTripDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addTrip";
        }
        tripService.addNewTrips(addNewTripDTO);
        return "addTripEffect";
    }
}
