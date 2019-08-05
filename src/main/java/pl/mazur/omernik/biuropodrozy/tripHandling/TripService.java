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

    public void createNewTrip(String tripDestination, Integer stockamount, BigDecimal price,
                                 TripType tripType, String continent, String country,
                                 String pictureURL, String airport,
                                 String hotel, LocalDate timeOfDeparture, LocalDate timeOfArrival, int numberOfDays) {
        Trip trip = tripType == TripType.NORMAL ? new NonPromotionTrip() : new PromotionalTrip();
        trip.setTripDestination(tripDestination);
        trip.setStockAmount(stockamount);
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

    public void updateTrip(TripDTO productDTO) {
        Trip s = tripToTripDTOBuilder.buildEntity(productDTO);
        tripRepository.save(s);
    }

    public Optional<Trip> findTrips(Long id) {
        return tripRepository.findProductById(id);
    }

    public List<Trip> findTripsToEdit(String query, String productType) {
        return findTrips(query, productType);
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

    public DataTablesResponse<TripDTO> getProductDataTable(Integer start, Integer length, String sortColumn, String sortOrder, String searchText) {
        DataTablesResponse<TripDTO> dtResponse = new DataTablesResponse<>();
        Page<Trip> booksByName = findTripByDestination(searchText, start == 0 ? 0 : (start / length), length, getSort(sortColumn, sortOrder));
        dtResponse.setData(booksByName.getContent()
                .stream()
                .map(tripToTripDTOBuilder::buildDto)
                .collect(Collectors.toList()));
        dtResponse.setRecordsTotal((int) booksByName.getTotalElements());
        dtResponse.setRecordsFiltered((int) booksByName.getTotalElements());
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



}
