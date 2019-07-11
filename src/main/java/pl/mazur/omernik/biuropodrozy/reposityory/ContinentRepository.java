package pl.mazur.omernik.biuropodrozy.reposityory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mazur.omernik.biuropodrozy.entity.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
