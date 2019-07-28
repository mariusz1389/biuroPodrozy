package pl.mazur.omernik.biuropodrozy.model.user.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mazur.omernik.biuropodrozy.model.user.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existByUsername (String username);

}
