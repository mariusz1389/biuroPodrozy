package pl.mazur.omernik.biuropodrozy.tripHandling;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.model.QTrip;
import pl.mazur.omernik.biuropodrozy.model.Trip;
import pl.mazur.omernik.biuropodrozy.tripHandling.database.DataTablesOrder;
import pl.mazur.omernik.biuropodrozy.tripHandling.database.DataTablesResponse;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TripService {



    @Autowired
    private TripRepository<Trip> tripRepository;

    @Autowired
    private TripToProductDTOBuilder tripToProductDTOBuilder;

    public void createNewProduct(String tripDestination, String continent, String country
            , String airport, String hotel, LocalDate timeOfDeparture
            , LocalDate timeOfArrival, int numberOfDays) {
        Trip trip = new Trip();
        trip.setTripDestination(tripDestination);
        trip.setContinent(continent);
        trip.setCountry(country);
        trip.setAirport(airport);
        trip.setHotel(hotel);
        trip.setTimeOfDeparture(timeOfDeparture);
        trip.setTimeOfArrival(timeOfArrival);
        trip.setNumberOfDays(numberOfDays);

        tripRepository.save(trip);
    }

    public void updateTrips(TripDTO productDTO) {
        Trip s = tripToProductDTOBuilder.buildEntity(productDTO);
        tripRepository.save(s);
    }

    public Optional<Trip> findTripId(Long id) {
        return tripRepository.findProductById(id);
    }

    public List<Trip> findTrips(String query, String destination) {
        return findTrips(query, destination);
    }


    public List<Trip> findAllTrips(){
        return tripRepository.findAll();
    }

    public void addNewTrips(AddTripDTO addTripDTO){
        Trip trip = AddTripDTOBuilder.rewriteToTrip(addTripDTO);
            tripRepository.save(trip);
    }
    private Page<Trip> findTripByDestination(String query, int page, int size, Sort sort) {
        Function<String, Page<Trip>> supplierForNotBlankQuery = (q) -> tripRepository.findAll(QTrip.trip.tripDestination.likeIgnoreCase("%" + q + "%").and(QTrip.trip.stockAmount.goe(1)), PageRequest.of(page, size, sort));
        Function<String, Page<Trip>> supplierForBlankQuery = (q) -> tripRepository.findAll(QTrip.trip.stockAmount.goe(1), PageRequest.of(page, size, sort));

        return StringUtils.isBlank(query) ? supplierForBlankQuery.apply(query) : supplierForNotBlankQuery.apply(query);
    }

    public List<TripDTO> findProductsForCustomer(String query, String tripType) {
        return findTrips(query, tripType)
                .stream()
                .filter(e -> ObjectUtils.defaultIfNull(e.getStockAmount(), 0) > 0)
                .map(tripToProductDTOBuilder::buildDto)
                .collect(Collectors.toList());
    }

    private Sort getSort(String name, String direction) {
        return direction.equalsIgnoreCase(DataTablesOrder.Direction.asc.name()) ? Sort.by(name).ascending() : Sort.by(name).descending();
    }

    public DataTablesResponse<TripDTO> getProductDataTable(Integer start, Integer length, String sortColumn, String sortOrder, String searchText) {
        DataTablesResponse<TripDTO> dtResponse = new DataTablesResponse<>();
        Page<Trip> booksByName = findTripByDestination(searchText, start == 0 ? 0 : (start / length), length, getSort(sortColumn, sortOrder));
        dtResponse.setData(booksByName.getContent()
                .stream()
                .map(tripToProductDTOBuilder::buildDto)
                .collect(Collectors.toList()));
        dtResponse.setRecordsTotal((int) booksByName.getTotalElements());
        dtResponse.setRecordsFiltered((int) booksByName.getTotalElements());
        return dtResponse;
    }

    @PostConstruct
    private void mockTrips() {
        createNewProduct("Majorka", "Europe", "Spain"
                , "Malorka Airport", "jakis tam"
                , LocalDate.of(2019, 06, 04)
                , LocalDate.of(2019, 06, 04)
                , 5);
    }



}
