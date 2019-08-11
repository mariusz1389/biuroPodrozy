package pl.mazur.omernik.biuropodrozy.tripHandling;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.tripHandling.database.DataTablesOrder;
import pl.mazur.omernik.biuropodrozy.tripHandling.database.DataTablesResponse;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
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
    private TripToTripDTOBuilder tripToTripDTOBuilder;

    public void createNewTrip(String tripDestination, Integer stockAmount, BigDecimal price,
                              TripType tripType, String continent, String country,
                              String pictureURL, String airport,
                              String hotel, LocalDate timeOfDeparture, LocalDate timeOfArrival, int numberOfDays) {
        Trip trip = new Trip();
        trip.setTripType(tripType);
        trip.setTripDestination(tripDestination);
        trip.setStockAmount(stockAmount);
        trip.setPrice(price);
        trip.setPictureUrl(pictureURL);
        trip.setContinent(continent);
        trip.setCountry(country);
        trip.setAirport(airport);
        trip.setHotel(hotel);
        trip.setTimeOfDeparture(timeOfDeparture);
        trip.setTimeOfArrival(timeOfArrival);
        trip.setNumberOfDays(numberOfDays);

        tripRepository.save(trip);
    }

    public void updateTrip(TripDTO tripDTO) {
        Trip s = tripToTripDTOBuilder.buildEntity(tripDTO);
        tripRepository.save(s);
    }

    public Optional<Trip> findTrips(Long id) {
        return tripRepository.findTripById(id);
    }

    public List<Trip> findTripsToEdit(String query, String tripType) {
        return findTrips(query, tripType);
    }


    public List<TripDTO> findTripsForCustomer(String query, String tripType) {
        return findTrips(query, tripType)
                .stream()
                .filter(e -> ObjectUtils.defaultIfNull(e.getStockAmount(), 0) > 0)
                .map(tripToTripDTOBuilder::buildDto)
                .collect(Collectors.toList());
    }

    public List<Trip> findTrips(String query, String tripType) {
        if (StringUtils.isBlank(query) && StringUtils.isBlank(tripType)) {
            return tripRepository.findAll();
        }
        if (StringUtils.isBlank(query)) {
            return tripRepository.findTripsByTripType(TripType.valueOf(tripType));
        }
        if (StringUtils.isBlank(tripType)) {
            return tripRepository.findTripsByTripDestinationLike(query);
        }
        return tripRepository.findByDestinationAndTripType(query, TripType.valueOf(tripType));
    }

    public Optional<TripDTO> findTripById(Long id) {
        return tripRepository.findById(id).map(tripToTripDTOBuilder::buildDto);
    }

    public DataTablesResponse<TripDTO> getTripDataTable(Integer start, Integer length, String sortColumn, String sortOrder, String searchText) {
        DataTablesResponse<TripDTO> dtResponse = new DataTablesResponse<>();
        Page<Trip> tripByDestination = findTripByDestination(searchText, start == 0 ? 0 : (start / length), length, getSort(sortColumn, sortOrder));
        dtResponse.setData(tripByDestination.getContent()
                .stream()
                .map(tripToTripDTOBuilder::buildDto)
                .collect(Collectors.toList()));
        dtResponse.setRecordsTotal((int) tripByDestination.getTotalElements());
        dtResponse.setRecordsFiltered((int) tripByDestination.getTotalElements());
        return dtResponse;
    }

    private Sort getSort(String name, String direction) {
        return direction.equalsIgnoreCase(DataTablesOrder.Direction.asc.name()) ? Sort.by(name).ascending() : Sort.by(name).descending();
    }

    private Page<Trip> findTripByDestination(String query, int page, int size, Sort sort) {
        Function<String, Page<Trip>> supplierForNotBlankQuery = (q) -> tripRepository.findAll(QTrip.trip.tripDestination.likeIgnoreCase("%" + q + "%").and(QTrip.trip.stockAmount.goe(1)), PageRequest.of(page, size, sort));
        Function<String, Page<Trip>> supplierForBlankQuery = (q) -> tripRepository.findAll(QTrip.trip.stockAmount.goe(1), PageRequest.of(page, size, sort));

        return StringUtils.isBlank(query) ? supplierForBlankQuery.apply(query) : supplierForNotBlankQuery.apply(query);
    }


    private void mockTrip(String tripDestination, Integer stockamount, BigDecimal price,
                          TripType tripType, String continent, String country,
                          String pictureURL, String airport,
                          String hotel, LocalDate timeOfDeparture, LocalDate timeOfArrival, int numberOfDays){

        NonPromotionTrip nonPromotionTrip = new NonPromotionTrip();
        nonPromotionTrip.setTripDestination(tripDestination);
        nonPromotionTrip.setStockAmount(stockamount);
        nonPromotionTrip.setPrice(price);
        nonPromotionTrip.setTripType(tripType);
        nonPromotionTrip.setContinent(continent);
        nonPromotionTrip.setCountry(country);
        nonPromotionTrip.setPictureUrl(pictureURL);
        nonPromotionTrip.setAirport(airport);
        nonPromotionTrip.setHotel(hotel);
        nonPromotionTrip.setTimeOfDeparture(timeOfDeparture);
        nonPromotionTrip.setTimeOfArrival(timeOfArrival);
        nonPromotionTrip.setNumberOfDays(numberOfDays);
        tripRepository.save(nonPromotionTrip);

    }

    @PostConstruct
    public void addMockTrips() {
        if (tripRepository.findAll().isEmpty()){
            mockTrip("Mallorca", 10,BigDecimal.ONE, TripType.NORMAL, "Europe", "Spain","https://www.pexels.com/photo/cottages-in-the-middle-of-beach-753626/",
                    "Mallorca Airport (PMI)", "Hilton", LocalDate.of(2019,06, 22), LocalDate.of(2019,06, 30),9  );
            mockTrip("Lisboa", 10,BigDecimal.valueOf(2500), TripType.NORMAL, "Europe", "Portugal","https://www.pexels.com/photo/people-in-front-of-white-and-orange-church-2098705/",
                    "Lisbon Airport (ZNZ)", "Hilton", LocalDate.of(2019,06, 22), LocalDate.of(2019,06, 30),9  );
            mockTrip("Berlin", 10,BigDecimal.valueOf(1200), TripType.NORMAL, "Europe", "Germany","https://www.pexels.com/photo/white-greek-site-under-cloudy-sky-53146/",
                    "Berlin Tegel (TXL)", "Hilton", LocalDate.of(2019,06, 22), LocalDate.of(2019,06, 30),9  );
        }
    }


}
