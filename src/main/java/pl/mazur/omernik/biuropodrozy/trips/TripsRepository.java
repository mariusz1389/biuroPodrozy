package pl.mazur.omernik.biuropodrozy.trips;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.mazur.omernik.biuropodrozy.entity.Trip;

import java.util.List;
import java.util.Optional;

public interface TripsRepository<T extends Trips> extends JpaRepository<Trips, Long>, QuerydslPredicateExecutor<Trips> {

    Optional<T> findProductById(Long id);

    List<T> findTripsByTripDestination(Trips destination);

//    @Query("select p from Product p where upper(p.title) like concat('%',upper(?1),'%')")
//    List<T> findTripsByTripTitleLike(String title);
//
//    @Query("select p from Product p where upper(p.title) like concat('%',upper(?1),'%') and p.productType = ?2")
//    List<T> findByTitleAndDestionation(String searchText, Trip destination);

}
