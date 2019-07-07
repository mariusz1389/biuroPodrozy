package pl.mazur.omernik.biuropodrozy.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mazur.omernik.biuropodrozy.entity.Trip;

@Repository
public interface TripRepo extends CrudRepository<Trip, Long> {
}
