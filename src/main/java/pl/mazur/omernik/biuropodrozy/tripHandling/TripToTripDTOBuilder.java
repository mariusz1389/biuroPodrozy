package pl.mazur.omernik.biuropodrozy.tripHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.model.Trip;

import java.util.Optional;

@Service
public class TripToTripDTOBuilder {



    @Autowired
    private TripRepository<Trip> tripRepository;

    public TripDTO buildDto(Trip trip) {
        return TripDTO.builder()
                .id(trip.getId())
                .tripType(trip.getTripType())
                .tripDestination(trip.getTripDestination())
                .continent(trip.getContinent())
                .country(trip.getCountry())
                .airport(trip.getAirport())
                .hotel(trip.getHotel())
                .timeOfDeparture(trip.getTimeOfDeparture())
                .timeOfArrival(trip.getTimeOfArrival())
                .numberOfDays(trip.getNumberOfDays())
                .pictureUrl(trip.getPictureUrl())
                .price(trip.getPrice())
                .stockAmount(trip.getStockAmount())
                .build();
    }//buildDto

    public Trip buildEntity(TripDTO dto) {
        Trip trip;
        if (dto.getId() == null) {
            if (dto.getTripType().isPromotion()){
                trip = new PromotionalTrip();
            }else {
                trip = new NonPromotionTrip();
            }
        } else {
            trip = tripRepository.getOne(dto.getId());
        }

        trip.setTripType(dto.getTripType());
        trip.setTripDestination(dto.getTripDestination());
        trip.setContinent(dto.getContinent());
        trip.setCountry(dto.getCountry());
        trip.setAirport(dto.getAirport());
        trip.setHotel(dto.getHotel());
        trip.setTimeOfDeparture(dto.getTimeOfDeparture());
        trip.setTimeOfArrival(dto.getTimeOfArrival());
        trip.setNumberOfDays(dto.getNumberOfDays());
        trip.setPictureUrl(dto.getPictureUrl());
        trip.setPrice(dto.getPrice());
        trip.setStockAmount(dto.getStockAmount());
        return trip;
    }

}
