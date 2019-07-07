package pl.mazur.omernik.biuropodrozy.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TripApi {

//    private TripRepo tripRepo;
//
//    @Autowired
//    public TripApi(TripRepo tripRepo) {
//        this.tripRepo = tripRepo;
//    }
//
//    @GetMapping
//    public Iterable<Trip> getCoffes() {
//        return tripRepo.findAll();
//    }
//
//    @PostMapping
//    public void addCoffee(@RequestBody Trip coffee)
//    {
//        tripRepo.save(coffee);
//    }
//
//    @DeleteMapping
//    public void removeCoffe(@RequestParam Long id) {
//        tripRepo.deleteById(id);
//    }
//
//    @PutMapping
//    public void putCoffee(@RequestBody Trip coffee)
//    {
//        Optional<Trip> element = tripRepo.findById(coffee.getId());
//        if(element.isPresent())
//        {
//            tripRepo.save(coffee);
//        }
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void get() {
//
//        Trip trip1 = new Trip("Londyn", "London Airport", "Continental", "23.07.2019",
//                "30.07.2019", 7);
//        Trip trip2 = new Trip("Warszawa", "Chopina", "Hilton", "23.07.2019",
//                "30.07.2019", 7);
//        Trip trip3 = new Trip("Libona", "Lizbona Airport", "Premium", "23.07.2019",
//                "30.07.2019", 7);
//
//        tripRepo.save(trip1);
//        tripRepo.save(trip2);
//        tripRepo.save(trip3);
//    }

}
