package pl.mazur.omernik.biuropodrozy.trips;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.mazur.omernik.biuropodrozy.entity.Trip;

import java.util.List;
import java.util.Optional;

public interface ProductRepository<T extends Product> extends JpaRepository<Product, Long>
        , QuerydslPredicateExecutor<Product>
{

    Optional<T> findProductById(Long id);
//    List<T> findProductsByTripDestinationTo(Trip trip);

    @Query("select p from Product p where upper(p.destinationTo) like concat('%',upper(?1),'%')")
    List<T> findProductsByTripDestinationTo(String destinationTo);


}
