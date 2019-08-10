package pl.mazur.omernik.biuropodrozy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.mazur.omernik.biuropodrozy.tripHandling.Trip;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripDTO;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripService;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class ApiTripController {

    @Autowired
    private TripService tripService;

//    List<Trip> trip = new ArrayList<>();
//    public String someText = "Nowa Wycieczka!";
//
//    @GetMapping("/trip")
//    public ModelAndView getMain() {
//        ModelAndView m = new ModelAndView("index");
//        m.setViewName("index");
//        m.addObject("someText", someText);
//        initTrip();
//        m.addObject("trips", trip);
//        return m;
//    }
//
//    public void initTrip() {
//        trip = tripService.findAllTrips();
//    }

    @GetMapping(value = "/trip")
    @ResponseBody
    public ResponseEntity<List<TripDTO>> showProducts(@RequestParam(required = false) String query, @RequestParam(required = false) String tripType) {
        List<TripDTO> productsForCustomer = tripService.findTripsForCustomer(query, tripType);
        return ResponseEntity.ok().body(productsForCustomer);
    }

    @GetMapping(value = "/trip/{id}")
    @ResponseBody
    public ResponseEntity<Trip> showProducts(@PathVariable Long id) {
        return ResponseEntity.ok().body(tripService.findTrips(id).orElse(null));
    }


}
