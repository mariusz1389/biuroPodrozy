package pl.mazur.omernik.biuropodrozy.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mazur.omernik.biuropodrozy.UserContextService;
import pl.mazur.omernik.biuropodrozy.tripHandling.Trip;
import pl.mazur.omernik.biuropodrozy.tripHandling.TripRepository;


@Controller
public class CartController {

    @Autowired
    private TripRepository<Trip> tripRepository;

    @Autowired
    private UserContextService userContextService;

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestParam(required = false) String prodId) {
        tripRepository.findProductById(Long.valueOf(prodId)).ifPresent(userContextService::addProductToCart);
        return ResponseEntity.ok().body(userContextService.getCartAsJson());
    }

    @GetMapping(value = "/cartElements")
    public ResponseEntity<String> cartElements() {
        String cartAsJson = userContextService.getCartAsJson();
        if (cartAsJson == null) {
            return ResponseEntity.badRequest().body("Brak produktów");
        }
        return ResponseEntity.ok().body(cartAsJson);
    }
}
