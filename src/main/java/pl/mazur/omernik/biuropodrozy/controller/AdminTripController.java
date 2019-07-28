package pl.mazur.omernik.biuropodrozy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.tripHandling.AddTripDTO;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin")
public class AdminTripController {


    @Autowired
    private TripService tripService;

    @GetMapping(value = "/addTrip")
    public ModelAndView administrateTrips(Model model) {
        ModelAndView modelAndView = new ModelAndView("addTrip");
        model.addAttribute("addNewTrip", new AddTripDTO());
        return modelAndView;
    }

    @PostMapping(value = "/addTrip")
    public ModelAndView addTripEffect(@ModelAttribute(name = "addNewTrip")
                                @Valid AddTripDTO addNewTripDTO, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("addTrip");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        tripService.addNewTrips(addNewTripDTO);
        return new ModelAndView("addTripEffect");
    }


}
