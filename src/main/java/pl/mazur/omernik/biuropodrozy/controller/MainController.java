package pl.mazur.omernik.biuropodrozy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.model.Trip;
import pl.mazur.omernik.biuropodrozy.model.user.CustomerRegistrationDto;
import pl.mazur.omernik.biuropodrozy.model.user.UserExistsException;
import pl.mazur.omernik.biuropodrozy.model.user.UserRegistrationService;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripService;

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

    public void initTrip() {

        trip = tripService.findAllTrips();

    }
    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "HI";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        model.addAttribute("customerFormData", new CustomerRegistrationDto());
//        model.addAttribute("countries", Countries.values());

        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String registerEffect(@ModelAttribute(name = "customerFormData")
                                 @Valid CustomerRegistrationDto customerFormData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
//            model.addAttribute("countries", Countries.values());
            return "registerForm";
        }
        try {
            userRegistrationService.registerUser(customerFormData);
        } catch (UserExistsException e) {
            model.addAttribute("userExistsException", e.getMessage());
            return "registerForm";
        }
        model.addAttribute("registrationData", customerFormData);
        return "registerEffect";
    }


}


