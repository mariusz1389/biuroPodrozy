package pl.mazur.omernik.biuropodrozy.tripHandling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface TripRepository<T extends Trip> extends JpaRepository<Trip, Long>, QuerydslPredicateExecutor<Trip> {

    Optional<T> findProductById(Long id);

    List<T> findTripsByTripType(TripType tripType);

    @Query("select t from Trip t where upper(t.tripDestination) like concat('%',upper(?1),'%')")
    List<T> findTripsByTripDestinationLike(String searchText);

    @Query("select t from Trip t where upper(t.tripDestination) like concat('%',upper(?1),'%') and t.tripType = ?2")
    List<T> findByDestinationAndTripType(String searchText, TripType tripType);

}
