package pl.mazur.omernik.biuropodrozy.reposityory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mazur.omernik.biuropodrozy.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
