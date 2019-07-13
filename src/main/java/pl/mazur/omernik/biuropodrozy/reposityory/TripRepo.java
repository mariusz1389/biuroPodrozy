package pl.mazur.omernik.biuropodrozy.reposityory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mazur.omernik.biuropodrozy.entity.Trip;


public interface TripRepo extends JpaRepository<Trip, Long> {
}
