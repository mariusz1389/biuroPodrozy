package pl.mazur.omernik.biuropodrozy.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existByUsername (String username);

}
