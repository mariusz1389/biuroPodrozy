package pl.mazur.omernik.biuropodrozy.trips;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface TripRepository<T extends Trip> extends JpaRepository<Trip, Long>, QuerydslPredicateExecutor<Trip> {

    Optional<T> findProductById(Long id);

    List<T> findTripsByTripDestination(Trip destination);

//    boolean existByTripDestination(String destination);

//    @Query("select p from Product p where upper(p.title) like concat('%',upper(?1),'%')")
//    List<T> findTripsByTripTitleLike(String title);
//
//    @Query("select p from Product p where upper(p.title) like concat('%',upper(?1),'%') and p.productType = ?2")
//    List<T> findByTitleAndDestionation(String searchText, Trip destination);

}
