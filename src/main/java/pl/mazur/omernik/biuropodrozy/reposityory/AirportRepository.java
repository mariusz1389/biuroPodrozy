package pl.mazur.omernik.biuropodrozy.reposityory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mazur.omernik.biuropodrozy.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
