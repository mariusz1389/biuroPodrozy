package pl.mazur.omernik.biuropodrozy.reposityory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mazur.omernik.biuropodrozy.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
