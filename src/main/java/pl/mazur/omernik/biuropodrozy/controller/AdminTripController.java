package pl.mazur.omernik.biuropodrozy.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripDTO;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripService;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class AdminTripController {


    @Autowired
    private TripService tripService;

    @PostMapping(value = "/trip/add")
    public String addTrip(@RequestParam String tripDestination,
                             @RequestParam Integer stockAmount,
                             @RequestParam BigDecimal price,
                             @RequestParam TripType tripType,
                             @RequestParam String continent,
                             @RequestParam String country,
                             @RequestParam String pictureUrl,
                             @RequestParam String airport,
                             @RequestParam String hotel,
                             @RequestParam String timeOfDeparture,
                             @RequestParam String timeOfArrival,
                             @RequestParam int numberOfDays) {
        tripService.createNewTrip(tripDestination, stockAmount, price, tripType, continent,
                country, pictureUrl, airport, hotel, LocalDate.parse(timeOfDeparture), LocalDate.parse(timeOfArrival), numberOfDays);
        return "redirect:/admin/trips";
    }

    @GetMapping(value = "/trip")
    public String addTrip(Model model) {
        model.addAttribute("tripTypes", TripType.values());

        return "addTrip";
    }

    @GetMapping(value = "/trip/{id}")
    public String editTrip(@PathVariable Long id, Model model) {
        Optional<TripDTO> tripToEdit = tripService.findTripById(id);
        if (tripToEdit.isPresent()) {
            model.addAttribute("tripToEdit", tripToEdit.get());
            model.addAttribute("tripTypes", TripType.values());
            return "editTrip";
        }
        return "redirect:/admin/trip";
    }

    @PostMapping(value = "/trip")
    public String editTrip(@ModelAttribute TripDTO trip) {
        tripService.updateTrip(trip);
        return "redirect:/admin/trips";
    }


    @GetMapping(value = "/trips")
    public String showTrips(@RequestParam(required = false) String query, @RequestParam(required = false) String tripType, Model model) {
        model.addAttribute("tripList", tripService.findTripsToEdit(query, tripType));
        model.addAttribute("tripTypes", TripType.values());
        model.addAttribute("query", StringUtils.defaultIfBlank(query, ""));
        model.addAttribute("tripType", Arrays.stream(TripType.values()).filter(t-> t.name().equals(tripType)).findFirst().orElse(null));
        return "adminTripList";
    }

}
